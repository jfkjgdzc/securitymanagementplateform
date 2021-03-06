<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://www.jee-soft.cn/functions" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="hotent" uri="http://www.jee-soft.cn/paging" %>
<%@ taglib prefix="spr" uri="http://www.springframework.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<f:link href="Aqua/css/ligerui-all.css"></f:link>
<f:link href="hotent/ats.css"></f:link>
<script type="text/javascript" src="${ctx}/js/dynamic.jsp"></script>
<script type="text/javascript" src="${ctx}/js/jquery/jquery.js"></script>
<f:js pre="js/lang/common" ></f:js>
<f:js pre="js/lang/js" ></f:js>
<script type="text/javascript" src="${ctx}/js/util/util.js"></script>
<script type="text/javascript" src="${ctx}/js/util/json2.js"></script>
<script type="text/javascript" src="${ctx}/js/lg/ligerui.min.js"></script>
<script type="text/javascript" src="${ctx}/js/hotent/displaytag.js" ></script>
<script type="text/javascript" src="${ctx}/js/calendar/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/js/lg/plugins/ligerDialog.js" ></script>
<script type="text/javascript" src="${ctx}/js/lg/plugins/ligerResizable.js" ></script>
<script type="text/javascript" src="${ctx}/js/lg/util/DialogUtil.js" ></script>
<link rel="stylesheet" type="text/css" href="${ctx}/styles/common/css/font-awesome/font-awesome.min.css"></link>
<link rel="stylesheet" type="text/css" href="${ctx}/styles/common/css/bootstrap/bootstrap.min.css"></link>
<f:link href="jqGrid/jquery-ui.css" ></f:link>
<f:link href="jqGrid/ui.jqgrid.css" ></f:link>
<link rel="stylesheet" type="text/css" href="${ctx}/styles/common/css/fullcalendar/fullcalendar.min.css"></link>
<!--[if lte IE 8]>
	<script type="text/javascript" src="${ctx}/js/bootstrap/html5shiv.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/bootstrap/respond.min.js"></script>
<![endif]-->
<script type="text/javascript" src="${ctx}/js/fullcalendar/moment.min.js"></script>
<script type="text/javascript" src="${ctx}/js/fullcalendar/fullcalendar.min.js"></script>
<script type="text/javascript" src="${ctx}/js/lang/fullcalendar/zh_CN.js"></script>
<script type="text/javascript" src="${ctx}/js/jqGrid/jquery.jqGrid.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jqGrid/i18n/grid.locale-cn.js"></script>
<script type="text/javascript" src="${ctx}/js/util/util.js"></script>
<script type="text/javascript" src="${ctx}/js/hotent/platform/ats/AtsDialog.js"></script>
<script type="text/javascript" src="${ctx}/js/hotent/platform/system/SysDialog.js"></script>