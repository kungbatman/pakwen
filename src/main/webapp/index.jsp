<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="resources/zTreeStyle/zTreeStyle.css" type="text/css">
    <link rel="stylesheet" type="text/css" href="resources/bootstrap/bootstrap.min.css">
    <title>index</title>
</head>
<body>
<h4>Ztree异步加载使用例子</h4>
<ul id="zTree" class="ztree"></ul>
</body>
<script src="resources/js/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.ztree.all.min.js"></script>
<script type="text/javascript">
    var setting = {
        async: {
            enable: true,
            url:"asyncGetNodes",
            autoParam:["id", "pid", "name"],
            dataFilter: filter
        },
        data:{
            simpleData:{
                enable: true,
                idKey:'id',
                pIdKey:'pid',
                rootPId: 0
            }
        },
        view:{
            showIcon: false
        }
    };
    $(document).ready(function(){
        initZTree();
    });

    function filter(treeId, parentNode, childNodes) {
        return childNodes;
    }
    //初始化树
    function initZTree(){
        $.ajax({
            url:"getNodes",
            type:"post",
            dataType: "json",
            success: function(data){
                console.log(data);
                var zTreeObj = $.fn.zTree.init($("#zTree"),setting, data);
                //让第一个父节点展开
                var rootNode_0 = zTreeObj.getNodeByParam('pid',0,null);
                zTreeObj.expandNode(rootNode_0, true, false, false, false);
            },
            error: function(){

            }
        });
    }

</script>
</html>