package ru.croc.task5;

public class AnnotatedImage {
    private final String imagePath;

    private final Annotation[] annotations;

    public AnnotatedImage(String imagePath, Annotation... annotations) {
        this.imagePath = imagePath;
        this.annotations = annotations;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public Annotation[] getAnnotations() {
        return this.annotations;
    }

    //Метод поиска по координатам, если не нашли то создаём новый
    public Annotation findByPoint(int x, int y) {
        for (Annotation annotation : annotations){
            if (annotation.getFigure().checkPoints(x, y)){
                return annotation;
            }
        }
        System.out.println("Annotation not found");
        return new Annotation(new Figure(),"null");
    }

    //Метод поиска по подписи, если не нашли то создаём новый
    Annotation findByLabel(String label) {
        for (Annotation annotation : annotations){
                if (annotation.checkCaption(label)){
                    return annotation;
            }
        }
        System.out.println("Annotation not found");
        return new Annotation(new Figure(),"null");
    }

    //Выводим массив
    public void printAnnotations() {
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }

}
