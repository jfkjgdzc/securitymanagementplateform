UE.commands['taskopinion'] = {
    execCommand:function (cmd) {
    	var me = this;
    	var html='<div name="editable-input" parser="taskopinionedit" class="taskopinion" instanceId="#instanceId#"><input type="text" /></div>';
        me.execCommand('insertHtml',html);
    },
    queryCommandState:function () {
        return this.highlight ? -1 : 0;
    }
};

