$(document).ready(function(){ 	
	 
	 $('#main_content').fullCalendar({
		    eventSources: [		        
		        {
		            url: 'admin_reserve_list',
		            type: 'GET',		           
		            error: function() {
		                alert('there was an error while fetching events!');
		            },
		            color: 'yellow',   // a non-ajax option
		            textColor: 'black' // a non-ajax option
		        }
		    ]

		});
 	
 }); //ready