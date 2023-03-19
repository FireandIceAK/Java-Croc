package ru.croc.task4;


public class Main {

    public static void main(String[] args){
        //Создаём массив аннотаций
        Annotation[] annotations = new Annotation[3];
        Figure figure1 = new Figure();
        Annotation annotation1 = new Annotation(figure1, "Красный");
        annotations[0] = annotation1;

        Figure figure2 = new Circle(3,1,5);
        Annotation annotation2 = new Annotation(figure2, "велосипед");
        annotations[1] = annotation2;

        Figure figure3 = new Rectangle(3,5,6,8);
        Annotation annotation3 = new Annotation(figure3,"синяя");
        annotations[2] = annotation3;

        //Выводим массив через класс annotatedImage
        AnnotatedImage annotatedImage = new AnnotatedImage("-", annotations);
        annotatedImage.printAnnotations();
    }
}
