<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<select name="st" disabled onchange="openOrCloseChooseSeat(this)" >
    <option value="0" >Select the showing date</option>
    <c:forEach var="tt" items="${timetables}" > 
        <option value="${tt.id}">${tt.showDate} - Room No.${tt.room.id}</option>
    </c:forEach>            
</select>
