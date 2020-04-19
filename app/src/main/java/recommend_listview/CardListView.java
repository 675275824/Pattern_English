package recommend_listview;

public class CardListView {
    private String little_title;
    private String time_item;
    private String include;
    private int imageId;
    public CardListView(int imageId,String   little_title,String time_item,String include){
       this.imageId=imageId;
       this.little_title=little_title;
       this.time_item=time_item;
       this.include=include;
    }
    public int getImageId(){
        return imageId;
    }

    public String getLittle_title() {
        return little_title;
    }

    public String getTime_item() {
        return time_item;
    }

    public String getInclude() {
        return include;
    }
}
