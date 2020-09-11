package com.fileTest;

/**
 * @author kung
 * @date 2019-09-27 18:21
 * @Description
 */
public class Nodes {
    private String id;
    private String pid;
    private String name;
    private String open;
    private String isParent;

    public Nodes(String id, String pid, String name, String open, String isParent) {
        super();
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.open = open;
        this.isParent = isParent;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPid() {
        return pid;
    }
    public void setPid(String pid) {
        this.pid = pid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getOpen() {
        return open;
    }
    public void setOpen(String open) {
        this.open = open;
    }
    public String getIsParent() {
        return isParent;
    }
    public void setIsParent(String isParent) {
        this.isParent = isParent;
    }
}
