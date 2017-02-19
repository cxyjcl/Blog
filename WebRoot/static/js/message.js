for(var i=0;i<jQuery('.visitword li a').length;i++){
    (function(x){
    	jQuery('.visitword li a')[x].onclick=function(){
        	var value = $(this).parent().find(".user").html();
        	var id = $(this).closest("li").attr("id");
        	jQuery("#append").remove();
        	jQuery("<div class=form id=append>" +
            "<form name=example method=post action='/Blog/reply.do?who="+value+"&visit_id="+id+"'>" +
            "<textarea name=word id=reply cols=100 rows=8 style=width:700px;height:200px;visibility:hidden;></textarea>"
            +"<br/>"
			+"<input type='submit' class='button' value='提交内容' /> (提交快捷键: Ctrl + Enter)" +
					"<input name='replyCheckbox' type='checkbox'/><span class='check'>私密回复</span>"
			+"</form>"
			+"</div>").insertAfter($(this).parent());
				var editor1 = KindEditor.create('#reply',{
				cssPath : './static/frame/kindeditor/plugins/code/prettify.css',
				uploadJson : './static/frame/kindeditor/jsp/upload_json.jsp',
				fileManagerJson : './static/frame/kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					KindEditor.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					KindEditor.ctrl(self.edit.doc, 13, function() {
						self.sync();
							document.forms['example'].submit();
					});
				}
			});
        }
    })(i);
}