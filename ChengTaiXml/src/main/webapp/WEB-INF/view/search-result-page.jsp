<%--
  Created by IntelliJ IDEA.
  User: cooper
  Date: 8/12/17
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>ChengTai</title>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/form-styles.css" />

    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.12.4.js" ></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-ui.js" ></script>
    <script src="${pageContext.request.contextPath}/resources/js/helpers.js" ></script>

</head>
<body>
    <div>
        <div id="searchTable">
        <form:form action="${pageContext.request.contextPath}/admin/search-result" modelAttribute='searchObject' method="post">
            <table>
                <tbody>
                <tr>
                    <td>Source Harbor:</td>
                    <td><form:input id="sourceHarborSearch" path="sourceHb" placeholder="Source Harbor"/></td>
                </tr>
                <tr>
                    <td>
                        <form:select path="cOrPSelect" onchange="changeList()">
                            <form:option value="pod">POD</form:option>
                            <form:option value="country">Country</form:option>
                        </form:select>
                    </td>
                    <td><form:input id="ctyOrPodSearch" path="ctyOrPod" placeholder="Country Or POD Name"/></td>
                </tr>
                <tr>
                    <td>From:</td>
                    <td><form:input id="DateFrom" path="dateFrom" placeholder="yyyy-mm-dd" /> </td>
                </tr>

                <tr>
                    <td>To:</td>
                    <td><form:input id="DateTo" path="dateTo" placeholder="yyyy-mm-dd" /> </td>
                </tr>

                <tr><td></td></tr>
                <tr><td></td></tr>
                <tr><td></td></tr>
                <tr>
                    <td></td>
                    <td><input style="float: right;" type="submit" value="Search"></td>
                </tr>
                </tbody>
            </table>
        </form:form>
        </div>
        <button id="addButton" type="button" onclick="onclickAdd()" >Add New Records</button>
        <button type="button" onclick="refresh()"> refresh</button>
        <div id="resultTable">
            <table>
                <tr>
                    <th>LAST MODIFIED</th>
                    <th>PODS</th>
                    <th>SOURCE HARBORS</th>
                    <th>COUNTRIES</th>
                    <th>CARRIERS</th>
                    <th>IMP INFO</th>
                    <th>20</th>
                    <th>40</th>
                    <th>40HQ</th>
                    <th>REMARK</th>
                    <th>FEEDER</th>
                    <th>HL CLS</th>
                    <th>ETP HK</th>
                    <th>T/T</th>
                    <th>EXTRA INFO</th>
                    <th>ACTION</th>
                </tr>

                <div id='newInfo'>
                    <form:form hidden="hidden" action='${pageContext.request.contextPath}/admin/saveTotalInfo' modelAttribute='totalInfoToAdd' method='post'>
                        <tbody id="add" hidden="hidden" >
                        <form:hidden path='id' />
                        <tr>
                            <td>-</td>
                            <td><form:input style="height: 30%; width: 80%; font-size: 130%;" path='pod' /></td>
                            <td><form:input style="height: 70%; width: 80%; font-size: 130%;" path='sourceHarbor' /> </td>
                            <td><form:input style="height: 70%; width: 80%; font-size: 130%;" path='country' /></td>
                            <td><form:input style="height: 70%; width: 80%; font-size: 130%;" path='carrier' /> </td>
                            <td><form:input style="height: 70%; width: 80%; font-size: 130%;" path='impInfo'/> </td>
                            <td><form:input style="height: 70%; width: 80%; font-size: 130%;" path='gq20'/> </td>
                            <td><form:input style="height: 70%; width: 80%; font-size: 130%;" path='gq40'/> </td>
                            <td><form:input style="height: 70%; width: 80%; font-size: 130%;" path='hq40'/> </td>
                            <td><form:input style="height: 70%; width: 80%; font-size: 130%;" path='remark'/> </td>
                            <td><form:input style="height: 70%; width: 80%; font-size: 130%;" path='feeder'/> </td>
                            <td><form:input style="height: 70%; width: 80%; font-size: 130%;" path='HKCLS'/> </td>
                            <td><form:input style="height: 70%; width: 80%; font-size: 130%;" path='ETPHK'/> </td>
                            <td><form:input style="height: 70%; width: 80%; font-size: 130%;" path='TT'/> </td>
                            <td><form:input style="height: 70%; width: 80%; font-size: 130%;" path='extraInfo'/> </td>
                            <td><input type='submit' value='Confirm'></td>
                        </tr>
                        </tbody>
                    </form:form>
                </div>

                <c:forEach var="totalInfo" items="${resultTotalInfo}">

                    <!-- url for update and delete -->
                    <c:url var="updateLink" value="${pageContext.request.contextPath}/admin/show-form-for-update">
                        <c:param name="totalInfoId" value="${totalInfo.id}"/>
                    </c:url>

                    <c:url var="deleteLink" value="${pageContext.request.contextPath}/admin/delete">
                        <c:param name="totalInfoId" value="${totalInfo.id}"/>
                    </c:url>
                    <tr>
                        <td>${totalInfo.lastModified}</td>
                        <td>${totalInfo.pod}</td>
                        <td>${totalInfo.sourceHarbor}</td>
                        <td>${totalInfo.country}</td>
                        <td>${totalInfo.carrier}</td>
                        <td>${totalInfo.impInfo}</td>
                        <td>${totalInfo.gq20}</td>
                        <td>${totalInfo.gq40}</td>
                        <td>${totalInfo.hq40}</td>
                        <td>${totalInfo.remark}</td>
                        <td>${totalInfo.feeder}</td>
                        <td>${totalInfo.HKCLS}</td>
                        <td>${totalInfo.ETPHK}</td>
                        <td>${totalInfo.TT}</td>
                        <td>${totalInfo.extraInfo}</td>
                        <td>
                            <a href="${updateLink}"> Update </a> <span class="action" onclick="popFieldsForUpdate(${totalInfo.id})">Update</span>
                            |
                            <a href="${deleteLink}" onclick=
                                    "showDeleteWarning()">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
<input type="date">
</body>

<script type="text/javascript">
    var countries = [];
    var pods = [];
    var sHarbors = []; // These three variables are acquired by ajax query
                        // They are used to auto-fill the input fields
    /*
    Pop input fields for update
    */
    function popFieldsForUpdate(id) {
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "${pageContext.request.contextPath}/json/update-total-info",
            data: JSON.stringify(id),
            dataType: 'json',  // specify respond dateFrom type
            timeOut: 10000,
            success: function (data) {
                console.log("update ajax succeeded");
                popUpdateForm(data);
            },
            error: function (e) {
                console.log("update ajax failed");
                console.log(e);
            }
        });
    }

    /*
    This function delete 'hidden' attribute from the adding menu accordingly
     */
    function onclickAdd(){
        var attr = $("#add").attr('hidden');

        if(attr !== undefined && attr !== false){
            $('#add').removeAttr('hidden');
            $('#addButton').text("cancel");
        } else {
            $('#add').attr('hidden', "hidden");
            $('#addButton').text("Add New Records");
        }

    }

    function changeList() {
        if ($("#cOrPSelect").val() === "pod") {
            myAutoComplete(pods, "#ctyOrPodSearch");
        } else {
            myAutoComplete(countries, "#ctyOrPodSearch");
        }
    }


    function popUpdateForm(TotalInfoToUpdate) {
        var message = $("<div></div>").text(1000);
        $("#test").after("");
    };


    //(function () {  //set default: 30 days from current time
      //  var dateFrom = new Date();
        //dateFrom.setDate(dateFrom.getDate() - 30);
        //window.document.getElementById("calenderFrom").valueAsDate = dateFrom;
    //})();

    (function () {  // query source harbor
        console.log("search request sent");
        var searchRequestJSON = {};
        searchRequestJSON["getPod"] = true;
        searchRequestJSON["getSourceHarbor"] = true;

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "${pageContext.request.contextPath}/json/get-pod",
            data: JSON.stringify(searchRequestJSON),
            dataType: 'json',
            timeOut: 10000,
            success: function (data) {
                console.log("search ajax succeeded");
                for (var i = 0; i < data.sourceHarborAJAXRespond.dataList.length; i++) {
                    sHarbors.push(data.sourceHarborAJAXRespond.dataList[i].sourceHarborName);
                }

                var previousCountry = null;
                for (var i = 0; i < data.podAJAXRespond.dataList.length; i++) {
                    if(previousCountry != data.podAJAXRespond.dataList[i].country){
                    countries.push(data.podAJAXRespond.dataList[i].country);
                    previousCountry = data.podAJAXRespond.dataList[i].country;
                    }
                }

                for (var i = 0; i < data.podAJAXRespond.dataList.length; i++) {
                    pods.push(data.podAJAXRespond.dataList[i].PODName);
                }
                myAutoComplete(sHarbors, "#sourceHarborSearch");
                myAutoComplete(pods, "#ctyOrPodSearch");
            },
            error: function (e) {
                console.log("search ajax failed");
                console.log(e);
            },
            done: function (e) {
                console.log("DONE");
                console.log(e);
            }

        });

    })();

</script>

</html>



