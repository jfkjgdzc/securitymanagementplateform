UE.registerUI('daterange', function(editor, uiName) {

	// 创建dialog
	var dialog = new UE.ui.Dialog({
		// 指定弹出层中页面的路径，这里只能支持页面,因为跟addCustomizeDialog.js相同目录，所以无需加路径
		iframeUrl : __ctx + '/js/ueditor1433/extend/daterange/daterangeDialog.jsp',
		// 需要指定当前的编辑器实例
		editor : editor,
		// 指定dialog的名字
		name : uiName,
		// dialog的标题
		title : "日期范围验证",

		// 指定dialog的外围样式
		cssRules : "width:400px;height:150px;",

		// 如果给出了buttons就代表dialog有确定和取消
		buttons : [ {
			className : 'edui-okbutton',
			label : '确定',
			onclick : function() {
				dialog.close(true);// true才触发dialog.onok
			}
		}, {
			className : 'edui-cancelbutton',
			label : '取消',
			onclick : function() {
				dialog.close(false);
			}
		} ]
	});

	// 参考addCustomizeButton.js
	var btn = new UE.ui.Button({
		name : "dialogbutton" + uiName,
		title : "日期范围验证",
		// 需要添加的额外样式，指定icon图标，这里默认使用一个重复的icon
		cssRules : 'background-position: -140px -20px;',
		onclick : function() {// 这个按钮进入的肯定是新增的，新增就删除这个编辑才用的对象
			// 渲染dialog
			dialog.render();
			dialog.open();
		},
		disabled:true
	});

	// 当点到编辑内容上时，按钮要做的状态反射
	editor.addListener('selectionchange', function() {
		var el = editor.selection.getStart();
		if ($(el).is("input")) {// input才能用
			dialog.targetEl = el;
			btn.setDisabled(false);
		} else {// 不是字段
			btn.setDisabled(true);
		}
		btn.setChecked(false);
		if ($(el).is("[validate]")) {
			var validate = eval("("+$(el).attr("validate")+")");
			if(validate.dateRangeStart||validate.dateRangeEnd){
				btn.setChecked(true);
			}
		}
		if ($(el).is("[ht-validate]")) {
			var validate = eval("("+$(el).attr("ht-validate")+")");
			if(validate.dateRangeStart||validate.dateRangeEnd){
				btn.setChecked(true);
			}
		}
	});

	return btn;
}/*
	 * index 指定添加到工具栏上的那个位置，默认时追加到最后,editorId
	 * 指定这个UI是那个编辑器实例上的，默认是页面上所有的编辑器都会添加这个按钮
	 */);