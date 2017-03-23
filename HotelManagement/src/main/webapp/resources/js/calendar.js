//달력 생성
$(document).ready(function() {
    $('#content_calendar').fullCalendar({
    	header : {    		
    		left : 'title',
    		right : 'today prev, next'
    	}
    	,events: [
        {
              title : "All Day Event"
            , start : "2017-03-23"
        }
        ]
    })
});
