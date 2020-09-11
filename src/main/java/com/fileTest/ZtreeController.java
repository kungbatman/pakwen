package com.fileTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kung
 * @date 2019-09-27 18:21
 * @Description
 */
@Controller
public class ZtreeController {

    @RequestMapping("/getNodes")
    @ResponseBody
    public List<Nodes> getNodes() throws Exception{
        List<Nodes> nodeList = new ArrayList<Nodes>();
        nodeList.add(new Nodes("1","0","硬件规格","false","true"));
        nodeList.add(new Nodes("10","1","单板","false","true"));
        nodeList.add(new Nodes("11","1","子卡","false","true"));
        nodeList.add(new Nodes("12","1","设备","false","true"));
        nodeList.add(new Nodes("2","0","软件规格","false","true"));
        nodeList.add(new Nodes("20","2","java","false","true"));
        nodeList.add(new Nodes("21","2","jscript","false","true"));
        nodeList.add(new Nodes("22","2","php","false","true"));
        return nodeList;
    }

    @RequestMapping("/asyncGetNodes")
    @ResponseBody
    public List<Nodes> asyncGetNodes(String id, String pid, String name) throws Exception{
        List<Nodes> nodeList = new ArrayList<Nodes>();
        if(id.equals("10")){
            nodeList.add(new Nodes("100",id,"单板_00","false","false"));
            nodeList.add(new Nodes("101",id,"单板_01","false","false"));
        }
        Thread.sleep(3000);
        return nodeList;
    }
}