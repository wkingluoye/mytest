package util;

public class ChatMsgEntity {  
    private static final String TAG = "ChatMsgEntity";  
  
    private String name;  
  
    private String date;  
  
    private String text;  
  
    private int layoutID;  
    
    private Boolean msgType;
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public String getDate() {  
        return date;  
    }  
  
    public void setDate(String date) {  
        this.date = date;  
    }  
  
    public String getText() {  
        return text;  
    }  
  
    public void setText(String text) {  
        this.text = text;  
    }  
  
    public int getLayoutID() {  
        return layoutID;  
    }  
  
    public void setLayoutID(int layoutID) {  
        this.layoutID = layoutID;  
    }  
  
    public ChatMsgEntity() {  
    }  
  
    public ChatMsgEntity(String name, String date, String text, int layoutID) {  
        super();  
        this.name = name;  
        this.date = date;  
        this.text = text;  
        this.layoutID = layoutID;  
        this.msgType = true;
    }

	public boolean getMsgType() {
		// TODO Auto-generated method stub
		return msgType;
	}

	public void setMsgType(boolean b) {
		// TODO Auto-generated method stub
		this.msgType = b;
		
	}

	public void setTime(String string) {
		// TODO Auto-generated method stub
		
	}

  
}

