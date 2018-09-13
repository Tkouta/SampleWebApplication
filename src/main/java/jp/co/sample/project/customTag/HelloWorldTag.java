/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.sample.project.customTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class HelloWorldTag implements Tag{
    private PageContext pageContext=null;
    private Tag parentTag=null;

    public void setPageContext(PageContext pageContext){
        this.pageContext=pageContext;
    }

    public void setParent(Tag parentTag){
        this.parentTag=parentTag;
    }

    public int doStartTag() throws JspException{
        return SKIP_BODY;
    }

    public int doEndTag() throws JspException{
        try{
          pageContext.getOut().print("Hello World");
        }catch(IOException e){
          throw new JspException(e.getMessage());
        }
        return EVAL_PAGE;
    }

    public void release(){}

    public Tag getParent(){
        return parentTag;
    }
}