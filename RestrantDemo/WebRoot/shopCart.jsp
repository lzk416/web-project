<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri='/struts-tags' prefix='s' %>

<html>
	<head>
		<title>���ﳵҳ��</title>
		<link rel="stylesheet" href="/Restrant/css/styles.css" type="text/css" />		
	</head>

	<body>
		<table width="90%" height="629" border="0" cellpadding="0"
			cellspacing="0" align="center">
			<tr>
				<td width="200" height="101">
					<img src="images/jb_logo.jpg" width="64" height="32" />
					<strong><span
						style="font-size: 20px;">���϶���ϵͳ</span> </strong>
				</td>
				<td width="640" style="padding-left: 40px;">
					
				</td>
			</tr>
			<tr>
				<td height="41" colspan="2"
					style="background-image:url(images/001.gif);" align="center">
					|
					<a href="/Restrant/toShowMeal">��վ��ҳ</a> |
					<s:if test="(#session.admin==null) && (#session.user==null)">					
					<a href="register.jsp">�û�ע��</a> |
					<a href="login.jsp?role=user">�û���¼</a> |
					<a href="login.jsp?role=admin">����Ա��¼</a> |
					</s:if>
					<s:if test="#session.user!=null">
					<a href="modifyMyInfo.jsp">�޸ĸ�����Ϣ</a> |
					<a href="shopCart.jsp">�ҵĹ��ﳵ</a> |
					<a href="/Restrant/toMyOrders">�ҵĶ���</a> |
					<a href="/Restrant/logOut?type=userlogout">ע��</a> &nbsp;&nbsp; &nbsp;&nbsp;
					<font style="color: red">��ӭ����${sessionScope.user.trueName }</font>					
					</s:if>
					<s:if test="#session.admin!=null">
					<a href="/Restrant/toAddMeal">��Ӳ�Ʒ</a> |
					<a href="/Restrant/toManageMeal">�����Ʒ</a> |
					<a href="/Restrant/toManageOrders">��������</a> |
					<a href="/Restrant/logOut?type=adminlogout">ע��</a> &nbsp;&nbsp; &nbsp;&nbsp;
					<font style="color: red">��ӭ����${sessionScope.admin.loginName }</font>
					</s:if>
				</td>
			</tr>
				<td valign="top" align="center" >
					<p>
						<img src="images/left_top.jpg" width="215" height="100" />
						<br>
						<img src="images/003.gif" width="191" height="8">
				</td>
				<td valign="top" width="80%">
					<img src="images/001.jpg" width="595" height="72" />
					<br />					
					<div style="background-image:url(images/004.gif)">
						&nbsp;
					</div>
						<br />
					<img src="images/zdkf.jpg" align="top" />
					���Ĺ��ﳵ����������Ʒ
					<br />
					<hr />	
					<table align="center" width="95%" cellspacing="0" cellpadding="3"
						style="text-align:center; border:1px #cccccc solid;">
						<tr style="background-color:#CCCCFF;">
							<td>���</td>
							<td>��Ʒ����</td>
							<td>����</td>
							<td>����</td>
							<td>���</td>
							<td>ɾ��</td>
						</tr>	
						<s:set var="sumPrice" value="0" />
						<s:iterator id="cartItem" value="#session.cart">
						 <tr style="background-color:#FFFFFF;">
						 <!--��Щ���Զ���Meal.java��������  -->
						 	<td><s:property value="value.meal.mealId"></s:property></td>
						 	<td><s:property value="value.meal.mealName"></s:property></td>
						 	<td>��<s:property value="value.meal.mealPrice"></s:property></td>
						 	<td>
						 		<input type="text" value="${value.quantity} size="10"
						 		onchange="window.location='updateSelectionQuantity?mealId=${value.meal.mealId }&quantity='+this.value;">
						 	</td>
						 	<td>
						 		��<s:property value="value.quantity*value.meal.mealPrice"></s:property>
						 	</td>
						 	<td>
						 		<a href="deleteSelectedOrders?mealId=${value.meal.mealId}">ɾ��</a>
						 	</td>
						 </tr>
						 	<s:set var="sumPrice" value="#sumPrice+value.quanytity*value.meal.mealPrice"/>
						</s:iterator>
						<tr style="background-color:#CCCCFF;">
							<td>
								�ϼ�
							</td>
							<td>
								-
							</td>
							<td>
								-
							</td>
							<td>
								-
							</td>
							<td>
								��:<s:property value="sumPrice" />
								<s:set var="sumPrice" value="#sumPrice" scope="session"/>
							</td>
							<td>
								-
							</td>
						</tr>			
					</table>
					<br />
					<table width="300" cellspacing="0" cellpadding="4" align="center" style="text-align:center; border:1px #cccccc solid;">
						<tr style="background-color:#CCCCFF;">
							<td>
								<a href="/Restrant/clearCart">��չ��ﳵ</a>
							</td>
							<td>
								<a href="/Restrant/toShowMeal">��������</a>
							</td>
							<td>
								<a href="/Restrant/addOrders">���ɶ���</a>
							</td>
						</tr>
					</table>	
			<tr>
				<td colspan="2" align="center">
					<br>
					<hr width=100%>					
					<br>
				</td>
			</tr>
		</table>
	</body>
</html>
