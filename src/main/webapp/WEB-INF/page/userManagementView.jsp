<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div>
	<div class="wrap" id="profile-page">
		<form id="your-profile" action="#"
			method="post">
			<h3>姓名</h3>
			<table class="form-table">
				<tbody>
					<tr>
						<th><label for="user_login">用户名</label></th>
						<td><input type="text" name="user_login" id="user_login"
							value="bolgxiaoxin" disabled="disabled" class="regular-text">
							<span class="description">用户名不可更改。</span></td>
					</tr>

					<tr>
						<th><label for="nickname">昵称 <span
								class="description">(必填)</span></label></th>
						<td><input type="text" name="nickname" id="nickname"
							value="小辛" class="regular-text"></td>
					</tr>

					<tr>
						<th><label for="display_name">公开显示为</label></th>
						<td><select name="display_name" id="display_name">
								<option selected="selected">小辛</option>
								<option>bolgxiaoxin</option>
						</select></td>
					</tr>
				</tbody>
			</table>

			<h3>联系信息</h3>

			<table class="form-table">
				<tbody>
					<tr>
						<th><label for="email">电子邮件 <span class="description">(必填)</span></label></th>
						<td><input type="text" name="email" id="email"
							value="myandroid@qq.com" class="regular-text"></td>
					</tr>

					<tr>
						<th><label for="url">站点</label></th>
						<td><input type="text" name="url" id="url"
							value="http://ixin.me" class="regular-text code"></td>
					</tr>
				</tbody>
			</table>

			<h3>关于您自己</h3>

			<table class="form-table">
				<tbody>
					<tr>
						<th><label for="description">个人说明</label></th>
						<td><textarea name="description" id="description" rows="5"
								cols="30"></textarea><br> <span class="description">分享关于您的一些信息。可能会被公开。</span></td>
					</tr>

					<tr id="password">
						<th><label for="pass1">新密码</label></th>
						<td><input type="password" name="pass1" id="pass1" size="16"
							value="" autocomplete="off"> <span class="description">如果您想修改您的密码，请在此输入新密码。不然请留空。</span><br>
							<input type="password" name="pass2" id="pass2" size="16" value=""
							autocomplete="off"> <span class="description">再输入一遍新密码。</span><br>
							<div id="pass-strength-result" style="display: block;">强度评估</div>
							<p class="description indicator-hint">提示：您的密码最好至少包含 7
								个字符。为了保证密码强度，使用大小写字母，数字和符号，例如 ! " ? $ % ^ &amp; )。</p></td>
					</tr> 
				</tbody>
			</table>

			<p class="submit">
				<input type="submit" name="submit" id="submit"
					class="button button-primary" value="更新个人资料">
			</p>
		</form>
	</div>
</div>