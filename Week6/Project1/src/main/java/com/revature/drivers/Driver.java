package com.revature.drivers;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;

import com.revature.controllers.AuthController;
import com.revature.controllers.EmployeeController;
import com.revature.controllers.ManagerController;

import io.javalin.Javalin;

public class Driver {
	public static void main(String[] args) {
//		Routes route = new Routes();
//		route.run();
//		}
		
		Javalin app = Javalin.create( (config) -> {		
			config.enableCorsForAllOrigins();
		}).start(7000);
		
		app.before(ctx -> {
			ctx.header("Access-Control-Allow-Headers", "Authorization");
			ctx.header("Access-Control-Expose-Headers", "Authorization");
		});

		
		
		app.routes(() -> {
			
			path("auth", ()->{			
					post(AuthController::login); //An Employee/Manager can login
			});
			path("account", ()->{				
					get(EmployeeController::viewInfo); //An Employee can view their information
					put(EmployeeController::updateInfo);  //An Employee can update their information
				
		});
			
			path("reimbursement", ()->{	 			
				post(EmployeeController::submitMyRequest); //An Employee can submit a reimbursement request	
				put(ManagerController::updateReStatus); //A Manager can approve/deny pending reimbursement requests
				
				path("pending",() ->{ 
					path("all",() ->{
					get(ManagerController::viewAllPending); //A Manager can view all pending requests from all employees
					});
					path("{username}",() ->{ //An employee can view their pending requests
						get(EmployeeController::viewMyPending);
					});
				});
				path("resolved",() ->{ 
					//Manager can view all resolved requests from all employees and see which manager resolved it
					path("all",() ->{
						get(ManagerController::viewAllResolved);
					});
					path("{id}",() ->{ 
						get(EmployeeController::viewMyResolved); //An employee can view their resolved request
					});
					
				});
				path("{id} ",() ->{  
					get(ManagerController::viewReByUserId); //Manager can view reimbursement requests from a single Employee 
				});
			});
			path("manager", ()->{
				path("employees",() ->{
					get(ManagerController::viewAllEmployees); //Manager can view all employees
				});
			});
					
		});
		
		}


}
