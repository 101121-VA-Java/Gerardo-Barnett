// let token = sessionStorage.getItem("token");
let api = "http://localhost:7000";
// if no token is present, redirect to the login page
if (!token) {
  window.location.href = "../login.html";
}

function addReimbursement() {
    console.log("Add Reimbursement!");
    let reimAmount = document.getElementById("amount").value;
    let description = document.getElementById("description").value;
    let author = sessionStorage.token.split(":")[0];
    let type = document.getElementById("type").value;
    let payload = { reimAmount, description, author, type };
    let xhr = new XMLHttpRequest();
    xhr.open("POST", `${api}/reimbursement`);
  
    xhr.onreadystatechange = function () {
      if (xhr.readyState === 4 && xhr.status === 200) {
        console.log("success");
      } else if (xhr.readyState === 4) {
        console.log("Something went wrong!");
      }
    };
    xhr.send(JSON.stringify(payload));
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
                <h1 class="display-4">Submit a Reimbursement</h1>
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
            result += `<div>Reimbursement Type: ${res[index].type}</div><br>`;
          }
          document.getElementById("empbox").innerHTML = result;
        })
        .catch((err) => console.log(err.message))
    );
  }

function viewProfile() {
    console.log("User information.");
    let seshId = sessionStorage.token.split(":")[0];
    fetch(`http://localhost:7000/user/${seshId}`, {
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
          // for (let index = 0; index < res.length; index++) {
          result += `<br><div>User ID: ${res.id}</div>`;
          result += `<div>Username: ${res.username}</div>`;
          result += `<div>Password: Password can't be shared.</div>`;
          result += `<div>First Name: ${res.firstName}</div>`;
          result += `<div>Last Name: ${res.lastName}</div>`;
          result += `<div>Email: ${res.email}</div>`;
          result += `<div>Role: ${res.role}</div>`;
          result += `<div>Manager: ${res.manager}</div>`;
          // }
          document.getElementById("empbox").innerHTML = result;
        })
        .catch((err) => console.log(err.message))
    );
  }


function updateWindow() {
    document.getElementById(
      "empbox"
    ).innerHTML = `<main class="container-fluid mx-auto " style="padding: 0 7.5em;">
    <div class="container align-content-center" id="updateProfile">
        <br>
        <br>
        <br>
        <br>
        <form>
            <div id="bottomBorder" class="form-row justify-content-center">
                <h1 class="display-4">Edit your profile</h1>
            </div>
            <hr>
            <br>
            <div class="form-row justify-content-center">
                <label>First Name</label>
            </div>
            <div class="form-row justify-content-center">
                <input class="inputstyle" type="text" name="firstname" id="firstname">
            </div>
            <br>
            <div class="form-row justify-content-center">
                <label>Last Name</label>
            </div>
            <div class="form-row justify-content-center">
                <input class="inputstyle" type="text" name="lastname" id="lastname">
            </div>
            <br>
            <div class="form-row justify-content-center">
                <label>User Name</label>
            </div>
            <div class="form-row justify-content-center">
                <input class="inputstyle" type="text" name="username" id="username">
            </div>
            <br>
            <div class="form-row justify-content-center">
                <label>Password</label>
            </div>
            <div class="form-row justify-content-center">
                <input class="inputstyle" type="text" name="password" id="password">
            </div>
            <br>
            <div class="form-row justify-content-center">
                <label>Email</label>
            </div>
            <div class="form-row justify-content-center">
                <input class="inputstyle" type="text" name="email" id="email">
            </div>
            <br>
            <br>
            <br>
            <br>
            <div class="form-row justify-content-center">
                <input class="btn btn-outline-secondary" value="Update Profile" id="submitUpdateProfile" onclick='updateEmployeeProfile(sessionStorage.token.split(":")[0])'>
            </div>
            <br>
            <br>
            <div class="form-row justify-content-center">
                <div style="color:red;" id="error-div"></div>
            </div>`;
  }
  

function updateEmployeeProfile(id) {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let firstName = document.getElementById("firstname").value;
    let lastName = document.getElementById("lastname").value;
    let email = document.getElementById("email").value;
  
    let xhr = new XMLHttpRequest();
    let payload = {id,firstName, lastName, username, password, email };
    xhr.open("PUT", `${api}/user/${id}`);
  
    xhr.onreadystatechange = function () {
      if (xhr.readyState === 4 && xhr.status === 200) {
        console.log("Profile updated!");
      } else if (xhr.readyState === 4) {
        console.log("Something went wrong");
      }
    };
    xhr.setRequestHeader("Authorization", sessionStorage.token);
    xhr.send(JSON.stringify(payload));
  }