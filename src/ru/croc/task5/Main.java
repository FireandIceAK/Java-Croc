package ru.croc.task5;

public class Main {

    public static void main(String[] args) {
        Annotation[] annotations = new Annotation[3];

        Figure figure1 = new Figure();
        Annotation annotation1 = new Annotation(figure1, "Null");
        annotations[0] = annotation1;

        Figure figure2 = new Circle(4, 2, 5);
        Annotation annotation2 = new Annotation(figure2, "Голубой");
        annotations[1] = annotation2;

        Figure figure3 = new Rectangle(4, 3, 1, -4);
        Annotation annotation3 = new Annotation(figure3, "Синий");
        annotations[2] = annotation3;

        AnnotatedImage annotatedImage = new AnnotatedImage("-", annotations);
        annotatedImage.printAnnotations();

        annotatedImage.findByLabel("Null").getFigure().move(5, 5);
        annotatedImage.findByPoint(4, 2).getFigure().move(3, 4);
        annotatedImage.printAnnotations();
    }
}
