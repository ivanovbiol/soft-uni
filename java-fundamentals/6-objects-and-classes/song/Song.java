public class Song {
    private String typeList;
    private String name;
    private String time;

    public Song(String typeList, String name, String time) {
        this.setTypeList(typeList);
        this.setName(name);
        this.setTime(time);
    }

    public String getTypeList() {
        return this.typeList;
    }

    public String getName() {
        return this.name;
    }

    private void setTypeList(String typeList) {
        this.typeList = typeList;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setTime(String time) {
        this.time = time;
    }
}
