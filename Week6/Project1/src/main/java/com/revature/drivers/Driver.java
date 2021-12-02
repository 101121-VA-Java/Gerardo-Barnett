package com.revature.drivers;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;

import com.revature.controllers.AuthController;
import com.revature.controllers.EmployeeController;
import com.revature.controllers.ManagerController;
import com.revature.controllers.UserController;
import com.revature.controllers.ReimbursementController;

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
			// /employees
			path("user", () -> {
				get(UserController::getUsers);
				post(UserController::registerEmployee);

				// use brackets to indicate path param name
				// /employees/{id}
				path("{id}", () -> {
					get(UserController::getEmployeeById);
					put(UserController::updateEmployeeInfo);
					path("status", () -> {
					path("{status}", () -> {
						get(ReimbursementController::empReimbursement);
					});
				});
			});
			});
			path("auth", () -> {
				post(AuthController::login);
			});
			path("reimbursement", () -> {
				get(ReimbursementController::get);
				post(ReimbursementController::add);
				path("{id}", () -> {

					put(ReimbursementController::update);

				});
				path("author", () -> {
					path("{id}", () -> {
						get(ReimbursementController::empGet);
					});

				});
				path("status", () -> {
					path("{id}", () -> {
						get(ReimbursementController::statusGet);

					});
				});
			});
		});
		
		}


}
