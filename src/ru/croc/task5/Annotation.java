package ru.croc.task5;

import ru.croc.task5.Figure;

public  class Annotation {

    private Figure figure;
    private String caption;


    public Annotation(){
        figure = new Figure();
        caption = "nothing";
    }

    public Annotation(Figure figure, String caption){
        this.figure = figure;
        this.caption = caption;
    }

    public String getCaption(){
        return caption;
    }

    public void setCaption(String caption){
        this.caption = caption;
    }

    public Figure getFigure(){
        return figure;
    }

    public void setFigure(Figure figure){
        this.figure = figure;
    }

    public boolean checkCaption(String caption){
        return this.caption.contains(caption);
    }

    //Вывод строкой
    @Override
    public String toString(){
        return figure.toString() + " " + caption;
    }
}
