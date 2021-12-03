// let token = sessionStorage.getItem("token");
let api = "http://localhost:7000";
// if no token is present, redirect to the login page
if (!token) {
  window.location.href = "../login.html";
}

function inputForm() {
    // (document.getElementById("manbox").innerhtml = inputform())
    console.log(5);
    document.getElementById("manbox").innerHTML = `<form onsubmit="return false">
      <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Please enter Employee ID</label>
        <input type="text" class="form-control" id="idInput" aria-describedby="emailHelp">
         
      </div>
      
      <button class="btn btn-primary" onclick="viewByEmp()">Submit</button>
      </form>`;
    console.log(7);
  }
  document.getElementById("logout-button").addEventListener("click", logout);
  // document
  //   .getElementById("reimbursements")
  //   .addEventListener("click", getAllReimbursements);
  
  function logout() {
    sessionStorage.clear();
    window.location.href = "../login.html";
  }
  function getAllReimbursements() {
    fetch(`http://localhost:7000/reimbursement`, {
      method: "GET",
      headers: {
        Authorization: token,
      },
    }).then((res) =>
      res
        .json()
        .then((res) => {
          console.log(res);
          let result = "";
          for (let index = 0; index < res.length; index++) {
            result += `<div>Reimbursement ID: ${res[index].reimId}</div>`;
            result += `<div>Amount: ${res[index].reimAmount}</div>`;
            result += `<div>Submitted On: ${res[index].submit}</div>`;
            result += `<div>Resolved At: ${res[index].resolved}</div>`;
            result += `<div>Description: ${res[index].description}</div>`;
            result += `<div>Submitted By: ${res[index].author}</div>`;
            result += `<div>Resolved By: ${res[index].resolver}</div>`;
            result += `<div>Status: ${res[index].status}</div>`;
            result += `<div>Reimbursement Type: ${res[index].type}</div><br>`;
            result += `<div>
              <button
                type="button"
                class="btn btn-success"
                onclick="changeReimbursement(${res[index].id}, 2)"
              >
                Approve
              </button>
              
            </div><br>`;
            result += `<div><button type="button" class="btn btn-danger" onclick="changeReimbursement(${res[index].id}, 3)">Deny</button></div><br>`;
          }
          document.getElementById("manbox").innerHTML = result;
        })
        .catch((err) => console.log(err.message))
    );
  }
  function addReimbursement() {
    console.log("Reimbursement working!");
    let amount = document.getElementById("amount").value;
    let description = document.getElementById("description").value;
    let authorId = sessionStorage.token.split(":")[0];
    let type = document.getElementById("type").value;
    let payload = { amount, description, authorId, type };
    let xhr = new XMLHttpRequest();
    xhr.open("POST", `${api}/reimbursement`);
  
    xhr.onreadystatechange = function () {
      if (xhr.readyState === 4 && xhr.status === 200) {
        console.log("success");
      } else if (xhr.readyState === 4) {
        console.log("An error occurred!");
      }
    };
    xhr.send(JSON.stringify(payload));
  }
  
  function changeReimbursement(reimId, status) {
    console.log(reimId);
    console.log(status);
  
    let xhr = new XMLHttpRequest();
    let payload = status;
    xhr.open("PUT", `${api}/reimbursement/${reimId}`);
  
    xhr.onreadystatechange = function () {
      if (xhr.readyState === 4 && xhr.status === 200) {
        console.log("Status changed");
      } else if (xhr.readyState === 4) {
        console.log("An error occurred");
      }
    };
    xhr.setRequestHeader("Authorization", sessionStorage.token);
    xhr.send(JSON.stringify(payload));
  }
  function getAllEmps() {
    fetch(`http://localhost:7000/user`, {
      method: "GET",
      headers: {
        Authorization: token,
      },
    }).then((res) =>
      res
        .json()
        .then((res) => {
          console.log(res);
          let result = "";
          for (let index = 0; index < res.length; index++) {
            result += `<br><div>User ID: ${res[index].id}</div>`;
            result += `<div>First Name: ${res[index].firstName}</div>`;
            result += `<div>Last Name: ${res[index].lastName}</div>`;
            result += `<div>User Name: ${res[index].username}</div>`;
            result += `<div>Email: ${res[index].email}</div>`;
            result += `<div>User Role: ${res[index].role}</div><br>`;
          }
          document.getElementById("manbox").innerHTML = result;
        })
        .catch((err) => console.log(err.message))
    );
  }
  function viewByEmp() {
    let id = document.getElementById("idInput").value;
    console.log(id);
    let api1 = "http://localhost:7000/reimbursement/author/" + id;
    fetch(`${api1}`, {
      method: "GET",
      headers: {
        Authorization: token,
      },
    }).then((res) =>
      res
        .json()
        .then((res) => {
          console.log(res);
          let result = "";
          for (let index = 0; index < res.length; index++) {
            result += `<div>Reimbursement ID: ${res[index].reimId}</div>`;
            result += `<div>Amount: ${res[index].reimAmount}</div>`;
            result += `<div>Submitted On: ${res[index].submit}</div>`;
            result += `<div>Resolved At: ${res[index].resolve}</div>`;
            result += `<div>Description: ${res[index].description}</div>`;
            result += `<div>Submitted By: ${res[index].author}</div>`;
            result += `<div>Resolved By: ${res[index].resolver}</div>`;
            result += `<div>Status: ${res[index].status}</div>`;
            result += `<div>Reimbursement Type: ${res[index].type}</div><br>`;
           
          }
          document.getElementById("manbox").innerHTML = result;
        })
        .catch((err) => console.log(err.message))
    );
  }
  function getByStatus(id) {
    console.log("In the function.");
    fetch(`http://localhost:7000/reimbursement/status/${id}`, {
      method: "GET",
      headers: {
        Authorization: token,
      },
    }).then((res) =>
      res
        .json()
        .then((res) => {
          console.log(res);
          let result = "";
          for (let index = 0; index < res.length; index++) {
            result += `<div>Reimbursement ID: ${res[index].reimId}</div>`;
            result += `<div>Amount: ${res[index].reimAmount}</div>`;
            result += `<div>Submitted On: ${res[index].submit}</div>`;
            result += `<div>Resolved At: ${res[index].resolve}</div>`;
            result += `<div>Description: ${res[index].description}</div>`;
            result += `<div>Submitted By: ${res[index].author}</div>`;
            result += `<div>Resolved By: ${res[index].resolver}</div>`;
            result += `<div>Status: ${res[index].status}</div>`;
            result += `<div>Reimbursement Type: ${res[index].type}</div><br>`;
          
          }
          document.getElementById("manbox").innerHTML = result;
        })
        .catch((err) => console.log(err.message))
    );
  }
  function addRWindow() {
    document.getElementById(
      "empbox"
    ).innerHTML = `<main class="container-fluid mx-auto " style="padding: 0 7.5em;">
    <div class="container align-content-center" id="AddReimbursement">
        <br>
        <br>
        <br>
        <br>
        <form>
            <div id="bottomBorder" class="form-row justify-content-center">
                <h1 class="display-4">Add Reimbursement</h1>
            </div>
            <hr>
            <br>
            <div class="form-row justify-content-center">
                <label>Amount:</label>
            </div>
            <div class="form-row justify-content-center">
                <input class="inputstyle" type="text" name="amount" id="amount">
            </div>
            <br>
            <div class="form-row justify-content-center">
                <label>Description</label>
            </div>
            <div class="form-row justify-content-center">
                <input class="inputstyle" type="text" name="description" id="description">
            </div>
            <br>
            <div class="form-row justify-content-center">
                <label>Type</label>
            </div>
            <div class="form-row justify-content-center">
                <input class="inputstyle" type="text" name="type" id="type">
            </div>
            <br>
            <br>
            <br>
            <br>
            <div class="form-row justify-content-center">
                <input class="btn btn-outline-secondary" value="Submit Request" id="addsubmitButton" onclick='addReimbursement()'>
            </div>
            <br>
            <br>
            <div class="form-row justify-content-center">
                <div style="color:red;" id="error-div"></div>
            </div>`;
  }
  function viewPending(statusId) {
    console.log("In the function.");
    let seshId = sessionStorage.token.split(":")[0];
    fetch(`http://localhost:7000/user/${seshId}/status/${statusId}`, {
      method: "GET",
      headers: {
        Authorization: token,
      },
    }).then((res) =>
      res
        .json()
        .then((res) => {
          console.log(res);
          let result = "";
          for (let index = 0; index < res.length; index++) {
            result += `<div>Reimbursement ID: ${res[index].reimId}</div>`;
            result += `<div>Amount: ${res[index].reimAmount}</div>`;
            result += `<div>Submitted On: ${res[index].submit}</div>`;
            result += `<div>Resolved At: ${res[index].resolve}</div>`;
            result += `<div>Description: ${res[index].description}</div>`;
            result += `<div>Submitted By: ${res[index].author}</div>`;
            result += `<div>Resolved By: ${res[index].resolver}</div>`;
            result += `<div>Status: ${res[index].status}</div>`;
            result += `<div>Reimbursement Type: ${res[index].type}</div><br>`;
          
          }
          document.getElementById("manbox").innerHTML = result;
        })
        .catch((err) => console.log(err.message))
    );
  }
  
  