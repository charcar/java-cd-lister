import java.util.ArrayList;

public class CD {
  private static ArrayList<CD> instances = new ArrayList<CD>();

  private String mTitle;
  private int mId;


  public CD(String title) {
    mTitle = title;
    instances.add(this);
    mId = instances.size();
  }

  public String getTitle() {
    return mTitle;
  }

  public static ArrayList<CD> all() {
    return instances;
  }

  public int getId() {
    return mId;
  }

  public static CD find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  public static void clear() {
    instances.clear();
  }


}
