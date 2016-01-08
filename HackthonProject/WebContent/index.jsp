<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.och.hackthon.services.BookService"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.och.hackthon.services.UserService"%>
<%@page import="com.och.hackthon.util.DBConnUtil"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="assets/css/index.css" />
<title>home</title>
</head>
<body>
	<div class="toplogin">
		<div class="loginright">
			<div class="loginbutton">
				<form id="formlogin"
					action="/HackthonProject/servlet/UserLoginServlet" method="post"
					class="toplogin">
					<label for="user" class="entypo-user"></label> <input id="user"
						type="text" class="toplogin" name="username"
						placeholder="username"> <label for="pwd"
						class="entypo-lock"></label> <input id="id" type="password"
						class="pass" name="password" placeholder="password">
					<button id="userloginbutton" class="submit">Login</button>
					<a id="userregister" href="register.jsp"
						style="margin-right: 10px;">Register</a>
				</form>
			</div>
		</div>
	</div>
	<div class="upper">
		<div class="wrap">
			<div class="left">
				<h1 class="logo" style="" itemprop="provider" color="write">
					Jurney Library</h1>
			</div>
		</div>
	</div>
	<div class="pagewrap" id="pagewrapid">
		<div id="pagetopid"></div>
		<div class="searchRes_container ">
			<div class="sidebar_left">
				<div class="lp_left_list_results" id="lp_left_list_results">
					<div id="leftNavigation">
						<ul id="categories_list" style="padding-left: 40px;">
							<li class=""><a href="#"><strong>Business&nbsp;(1101)</strong></a></li>
							<p></p>
							<li class=""><a href="#"><strong>Desktop and
										Web Applications&nbsp;(718)</strong></a></li>
							<p></p>
							<li class=""><a href="#"><strong>Digital
										Media&nbsp;(958)</strong></a></li>
							<p></p>
							<li class=""><a href="#"><strong>Information
										Technology & Software Development&nbsp;(849)</strong></a></li>
							<p></p>
							<li class=""><a href="#"><strong>Math &
										Science&nbsp;(248)</strong></a></li>
							<p></p>
							<li class=""><a href="#"><strong>Personal &
										Professional Development&nbsp;(152)</strong></a></li>
							<p></p>
							<li class=""><a href="#"><strong>Product&nbsp;(3788)</strong></a></li>
							<p></p>
							<li class=""><a href="#"><strong>Vendor&nbsp;(4301)</strong></a></li>
							<p></p>
						</ul>
					</div>
				</div>
			</div>
			<div class="paneR">
				<div style="width: 100%;">
					<div class="hdr_block">
						<div class="right">
							<div class="searchModule">
								<div class="searchWrap">
									<div class="form">
										<input type="text"
											onkeydown="javascript:if(event.keyCode==13) search('key');"
											autocomplete="off" id="key" accesskey="s" class="text"
											clstag="shangpin|keycount|toplist1|b02">
										<button onclick="search('key');return false;"
											class="button cw-icon"
											clstag="shangpin|keycount|toplist1|b03">
											<i></i>SEARCH
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div id="searchtop" style="margin-top: 50px;">
					<div>

						<div class="searchMore_box">
							<div class="bluBrdrBox0">
								<div class="blubr1ct">
									<div class="blubr1cl"></div>
								</div>
								<div class="blubrBoxContent">
									<form method="post" action="/search" id="form_467874">
										<input id="searchinput" type="hidden" name="__formName"
											value="467874">
										<p class="p">
											<label class="hide_label" for="searchnewword"><span>Search
													Further </span></label><input class="txt_230px" id="searchnewword"
												type="text" name="__searchnewword"
												value="[Add Term(s) to Narrow Your Search]"><span>
											</span><label class="hide_label" for="searchresultslistbox"><span>Search
													Further </span></label><select id="searchresultslistbox"
												name="__searchresultslistbox"><option value="">All
													Results</option>
												<option value="BOOKTITLE">Book/Video Titles</option>
												<option value="SHORTCUTS">Short Cuts</option>
												<option value="ROUGHCUTS">Rough Cuts</option>
												<option disabled="disabled" value="">----------------------</option>
												<option value="INMYFOLDERS">Any Private Folder</option>
												<option value="3671242">- Big data</option>
												<option value="3659499">- Presentation</option>
												<option value="3508162">- My List</option></select> <input
												type="text" style="visibility: hidden; display: none;">
											<input class="btn" id="submitnewword"
												alt="Search Within Results" value="Search Within Results"
												src="./images/btn_search_searchwithin.gif" type="image"
												name="__submitnewword" title="Search Within Results">
										</p>
									</form>
								</div>
								<div class="blubr1bl">
									<div class="blubr1br"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="results_container">
					<table class="searchRes_table " id="searchanchor_9781784399092"
						cellspacing="0" cellpadding="0" style="margin-top: 10px;">
						<tbody>
							<%
					ResultSet rs = null;
					UserService us = new UserService();
					BookService bs = new BookService();
					Connection conn = DBConnUtil.getConnection();
					rs = bs.getAllBooks(conn);
					 while (rs.next()) {						
				%>
							<tr valign="top">
								<td class="searchRes_number" width="6%">
									<div style="width: 100%;"></div> <input
									class="booklistcheckbox" type="checkbox" name="vehicle"
									value="1" />
								</td>
								<td class="searchRes_details" width="45%">
									<div style="width: 100%;"></div>
									<div class="result_itemBlock">
										<div class="bluBrdrBox1">
											<div class="blubr1ct">
												<div class="blubr1cl"></div>
												<div class="blubrBoxContent">
													<div class="bookpicture">
														<img class="bookCover"
															alt="RESTful Java Web Services - Second Edition"
															title="RESTful Java Web Services - Second Edition"
															width="76" src=<%= rs.getString("imgPath")%>>
													</div>
													<div class="bookData">
														<p class="p bookTitle" style="margin-top: 8px;">RESTful
															Java</p>
														<P></P>
														<p class="p bookText bookAuthors">
															<strong class="strong">By:&nbsp;</strong>
															<%= rs.getString("Author")%>
														</p>
														<p class="p bookText bookPublisher">
															<strong class="strong">Publisher:&nbsp;</strong>
															<%= rs.getString("Publisher") %>
														</p>
														<form action="">
															<button type="submit" class="booklistsubmit">SUBMIT</button>
														</form>
													</div>
												</div>
											</div>
										</div>
									</div>
								</td>
								<td class="searchRes_content" width="30%">
									<div style="width: 100%;">
										<p class="p section_info">
											<b>Chapter Title: Asynchronous RESTful web services</b>
										</p>
										<div class="snippet" style="max-height: 70px;">
											<%=rs.getString("Description")%>
										</div>
									</div>
								</td>
							</tr>
							<%}	%>	  
						</tbody>
					</table>
					<hr>
					<div class="pagination">
						<p id="pageNaviation" class="p nobotpad">
							<span class="span count"><span>1-20 of </span><strong
								class="strong">10934 Items</strong></span><strong class="strong"><span>
							</span><span class="disabledblacktext">&lt; Prev</span><span
								class="disabledblacktext"> | </span><span class="cur_num">1</span><span
								class="disabledblacktext"> </span><a class="nums"
								href="?page=1&amp;srcfilters=7&amp;sort=rank&amp;order=desc&amp;te=,&amp;srcuserquery=(web+services)"
								onclick="link('page=1&amp;srcfilters=7&amp;sort=rank&amp;order=desc&amp;te=,&amp;srcuserquery=(web+services)', 'searchresults'); return false;"
								data-bow-ajax="searchresults">2</a><span
								class="disabledblacktext"> </span><a class="nums"
								href="?page=2&amp;srcfilters=7&amp;sort=rank&amp;order=desc&amp;te=,&amp;srcuserquery=(web+services)"
								onclick="link('page=2&amp;srcfilters=7&amp;sort=rank&amp;order=desc&amp;te=,&amp;srcuserquery=(web+services)', 'searchresults'); return false;"
								data-bow-ajax="searchresults">3</a><span
								class="disabledblacktext"> </span><a class="nums"
								href="?page=3&amp;srcfilters=7&amp;sort=rank&amp;order=desc&amp;te=,&amp;srcuserquery=(web+services)"
								onclick="link('page=3&amp;srcfilters=7&amp;sort=rank&amp;order=desc&amp;te=,&amp;srcuserquery=(web+services)', 'searchresults'); return false;"
								data-bow-ajax="searchresults">4</a><span
								class="disabledblacktext"> </span><a class="nums"
								href="?page=4&amp;srcfilters=7&amp;sort=rank&amp;order=desc&amp;te=,&amp;srcuserquery=(web+services)"
								onclick="link('page=4&amp;srcfilters=7&amp;sort=rank&amp;order=desc&amp;te=,&amp;srcuserquery=(web+services)', 'searchresults'); return false;"
								data-bow-ajax="searchresults">5</a><span
								class="disabledblacktext">...</span><a class="nums"
								href="?page=546&amp;srcfilters=7&amp;sort=rank&amp;order=desc&amp;te=,&amp;srcuserquery=(web+services)"
								onclick="link('page=546&amp;srcfilters=7&amp;sort=rank&amp;order=desc&amp;te=,&amp;srcuserquery=(web+services)', 'searchresults'); return false;"
								data-bow-ajax="searchresults">547</a><span
								class="disabledblacktext"> | </span><a class="pagenext"
								href="?page=1&amp;srcfilters=7&amp;sort=rank&amp;order=desc&amp;te=,&amp;srcuserquery=(web+services)"
								data-bow-ajax="searchresults" title="Next >">Next &gt;</a></strong>
						</p>
					</div>
					<div class="bottom"></div>

				</div>
			</div>
		</div>
	</div>
</body>
</html>