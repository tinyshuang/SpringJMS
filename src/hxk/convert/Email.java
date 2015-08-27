package hxk.convert;

import java.io.Serializable;

/**
 * @author Administrator
 * @description
 *2015-7-23  上午11:29:15
 */
public class Email implements Serializable{
    private static final long serialVersionUID = 513180384744207590L;
    
    private String recevie;
    private String title;
    private String content;
    
    
    public Email(String recevie, String title, String content) {
	this.recevie = recevie;
	this.title = title;
	this.content = content;
    }
    
    public Email() {}


    public String getRecevie() {
        return recevie;
    }
    public void setRecevie(String recevie) {
        this.recevie = recevie;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    
    
    
    @Override
    public String toString() {
	return "Email [recevie=" + recevie + ", title=" + title + ", content="
		+ content + "]";
    }
    
    
}
