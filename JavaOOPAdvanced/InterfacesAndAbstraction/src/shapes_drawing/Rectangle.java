package shapes_drawing;

public class Rectangle implements Drawable {

    private Integer width;
    private Integer height;

    public Rectangle(Integer width, Integer height) {
        this.setWidth(width);
        this.setHeight(height);
    }


    public Integer getWidth() {
        return this.width;
    }

    private void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return this.height;
    }

    private void setHeight(Integer height) {
        this.height = height;
    }

    private void drawLine(Integer width, char end, char mid) {
        System.out.print(end);
        for (int i = 1; i < width - 1; ++i)
            System.out.print(mid);
        System.out.println(end);
    }

    @Override
    public void draw() {
        drawLine(this.width, '*', '*');
        for (int i = 1; i < this.height - 1; ++i)
            drawLine(this.width, '*', ' ');
        drawLine(this.width, '*', '*');
    }


}
