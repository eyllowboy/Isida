package beans;

import entity.Link;
import utils.Parser;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import javax.faces.context.FacesContext;

import java.util.List;

import static javax.faces.application.FacesMessage.SEVERITY_ERROR;

@ManagedBean(name = "search")
@ViewScoped
public class Search   {

    private String url;
    private List<Link> linkList;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Link> getLinkList() {
        return linkList;
    }

    public void setLinkList(List<Link> linkList) {
        this.linkList = linkList;
    }

    public void clearLinkList() {
         linkList = null;
    }

    public void findAllLinks() {
        try {
            linkList = Parser.parse(url);

        } catch (Exception e) {
            ErrorMessage();
        }

    }

    public void ErrorMessage() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(SEVERITY_ERROR, "Error", "Ошибка анализа"));
    }

}
