
let api1 = "http://localhost:7000";

function login(){
    document.getElementById("error-div").innerHTML = "";

    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    let xhr = new XMLHttpRequest();
    xhr.open("POST", `${api1}/auth`);

    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            
            let authToken = xhr.getResponseHeader("Authorization");

            sessionStorage.setItem("token", authToken);

            let tok = sessionStorage.getItem("token");
            // console.log(authToken);
            // if(tok.split(":")[1] == 2)
            if(username == 'gerardoB'){
               
                window.location.href = "../views/manager/manager.html";
                
                
            } else {
                window.location.href="../views/employee/employee.html";
                

                // C:\Users\gerar\Documents\JavaExercises\Gerardo-Barnett\Week6\Project1\src\views
            }
            

        } else if (xhr.readyState === 4){
            // provide user with feedback of failure to login
            document.getElementById("error-div").innerHTML = xhr.response;
           }

        }

        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

        let requestBody = `username=${username}&password=${password}`;

        xhr.send(requestBody);
}




document.getElementById("logout").addEventListener('click', LogOut);

function LogOut(){
    sessionStorage.clear();
    window.location.href = "../login.html";
}