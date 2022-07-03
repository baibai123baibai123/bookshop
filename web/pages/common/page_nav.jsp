<%--
  Created by IntelliJ IDEA.
  User: baibi
  Date: 2022/5/3
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    //        跳转到指定页面
    $(function () {
        $("#pageButton").click(function () {
            var pageNo = $("#pn_input").val();
            var pageTotal =${requestScope.page.pageTotal};
            if (pageNo < 1) {
                location.href = "${pageScope.basePath}${requestScope.page.url}&pageNo=1";
            } else if (pageNo > pageTotal) {
                location.href = "${pageScope.basePath}${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}";
            } else {
                <%--location.href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/"+"manager/bookServlet?action=page&pageNo="%>"+pageNo;--%>
                location.href = "${pageScope.basePath}${requestScope.page.url}&pageNo=" + pageNo;
            }
        })
    })
</script>

<%--分页开始--%>
<div id="page_nav">
    <%--首页不显示上一页--%>
    <c:if test="${requestScope.page.pageNo>1}">
        <a href="${requestScope.page.url}&pageNo=1">首页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
    </c:if>
    <%--处理页码--%>
    <c:choose>
        <%--当页码总数小于等于5时--%>
        <c:when test="${requestScope.page.pageTotal<=5}">
            <c:forEach begin="1" end="${requestScope.page.pageTotal}" var="i">
                <%--当前页不用支持跳转并加粗展示--%>
                <c:if test="${i==requestScope.page.pageNo}">
                    【${i}】
                </c:if>
                <c:if test="${i!=requestScope.page.pageNo}">
                    <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                </c:if>
            </c:forEach>
        </c:when>
        <%--总页码大于五时--%>
        <c:when test="${requestScope.page.pageTotal>5}">
            <c:choose>
                <%--当页码为前三个时--%>
                <c:when test="${requestScope.page.pageNo<=3}">
                    <c:forEach begin="1" end="5" var="i">
                        <%--当前页不用支持跳转并加粗展示--%>
                        <c:if test="${i==requestScope.page.pageNo}">
                            【${i}】
                        </c:if>
                        <c:if test="${i!=requestScope.page.pageNo}">
                            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:when>
                <%--当前页码为最后三个时--%>
                <c:when test="${requestScope.page.pageNo>requestScope.page.pageTotal-3}">
                    <c:forEach begin="${requestScope.page.pageTotal-4}" end="${requestScope.page.pageTotal}" var="i">
                        <c:if test="${i==requestScope.page.pageNo}">
                            【${i}】
                        </c:if>
                        <c:if test="${i!=requestScope.page.pageNo}">
                            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:when>
                <%--最后一种情况为：页码范围为当前页码-2到当前页码加2--%>
                <c:when test="${requestScope.page.pageNo>=4&&requestScope.page.pageNo<=requestScope.page.pageTotal-3}">
                    <c:forEach begin="${requestScope.page.pageNo-2}" end="${requestScope.page.pageNo+2}" var="i">
                        <c:if test="${i==requestScope.page.pageNo}">
                            【${i}】
                        </c:if>
                        <c:if test="${i!=requestScope.page.pageNo}">
                            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:when>
            </c:choose>
        </c:when>
    </c:choose>
    <%--末页不显示下一页--%>
    <c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
    </c:if>

    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
    到第<input value="${requestScope.page.pageNo}" name="pn"
             id="pn_input"/>页
    <input id="pageButton" type="button" value="确定">
</div>
<%--分页结束--%>
