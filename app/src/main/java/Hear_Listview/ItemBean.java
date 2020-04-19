package Hear_Listview;

public class ItemBean {
    private String little_title;
    private int imageId;
    public ItemBean(int imageId,String   little_title){
        this.imageId=imageId;
        this.little_title=little_title;
    }

    public String getLittle_title() {
        return little_title;
    }

    public void setLittle_title(String little_title) {
        this.little_title = little_title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}

