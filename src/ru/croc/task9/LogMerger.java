package ru.croc.task9;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogMerger {

    private static final String[] LOG_EXTENSIONS = new String[]{".log", ".trace"};
    private static final SimpleDateFormat LOG_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    public static void main(String[] args) throws IOException, ParseException {
        if (args.length == 0) {
            System.err.println("Usage: java LogMerger <logsDirectory>");
            System.exit(1);
        }

        Path logsDirectoryPath = Paths.get(args[0]);
        if (!Files.isDirectory(logsDirectoryPath)) {
            System.err.println("Error: " + args[0] + " is not a directory");
            System.exit(1);
        }

        List<Path> logFilePaths = collectLogFilePaths(logsDirectoryPath);
        if (logFilePaths.isEmpty()) {
            System.out.println("No log files found in directory " + args[0]);
            return;
        }

        PriorityQueue<LogLine> logLines = new PriorityQueue<>(logFilePaths.size(), Comparator.comparing(LogLine::getTime));
        List<BufferedReader> readers = new ArrayList<>(logFilePaths.size());

        for (Path logFilePath : logFilePaths) {
            BufferedReader reader = new BufferedReader(new FileReader(logFilePath.toFile()));
            readers.add(reader);

            String line = reader.readLine();
            if (line != null) {
                logLines.add(new LogLine(LOG_DATE_FORMAT.parse(line.substring(0, line.indexOf(' '))).getTime(), logFilePath, line));
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            while (!logLines.isEmpty()) {
                LogLine logLine = logLines.poll();
                writer.write(logLine.line);
                writer.newLine();

                BufferedReader reader = readers.get(logFilePaths.indexOf(logLine.logFilePath));
                String nextLine = reader.readLine();
                if (nextLine != null) {
                    logLines.add(new LogLine(LOG_DATE_FORMAT.parse(nextLine.substring(0, nextLine.indexOf(' '))).getTime(), logLine.logFilePath, nextLine));
                }
            }
        } finally {
            for (BufferedReader reader : readers) {
                reader.close();
            }
        }
    }

    private static List<Path> collectLogFilePaths(Path dirPath) throws IOException {
        try (Stream<Path> walk = Files.walk(dirPath)) {
            return walk
                    .filter(LogMerger::isLogFilePath)
                    .sorted()
                    .collect(Collectors.toList());
        }
    }

    private static boolean isLogFilePath(Path path) {
        if (Files.isRegularFile(path))
            if (Arrays.stream(LOG_EXTENSIONS).anyMatch(ext -> Boolean.parseBoolean(path.getFileName().toString())))
                return true;
        return false;
    }
}