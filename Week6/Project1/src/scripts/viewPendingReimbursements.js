let token = sessionStorage.getItem("token");
let api = "http://localhost:7000";
// if no token is present, redirect to the login page
if (!token) {
  window.location.href = "../login.html";
}


function logout() {
  sessionStorage.clear();
  window.location.href = "../login.html";
}



function getAllReimbursements() {
  fetch(`http://localhost:7000/reimbursement/pending`, {
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
          result += `<div>Reimbursement ID: ${res[index].id}</div>`;
          result += `<div>Amount: ${res[index].amount}</div>`;
          result += `<div>Submitted On: ${res[index].submitted}</div>`;
          result += `<div>Resolved At: ${res[index].resolved}</div>`;
          result += `<br><div>Description: ${res[index].description}</div>`;
          result += `<div>Submitted By: ${res[index].authorId}</div>`;
          result += `<div>Resolved By: ${res[index].resolverId}</div>`;
          result += `<div>Reimbursement ID: ${res[index].id}</div>`;
          result += `<div>Reimbursement Type: ${res[index].type}</div>`;
          result += `<div>
            <button
              type="button"
              class="btn btn-success"
              onclick="changeReimbursement(${res[index].id}, 2)"
            >
              Approve
            </button>
            
          </div>`;
          result += `<div><button type="button" class="btn btn-danger" onclick="changeReimbursement(${res[index].id}, 3)">Deny</button></div>`;
        }
        document.getElementById("manbox").innerHTML = result;
      })
      .catch((err) => console.log(err.message))
  );
}

function changeReimbursement(reimbId, statusId) {
  console.log(reimbId);
  console.log(statusId);

  let xhr = new XMLHttpRequest();
  let payload = statusId;
  xhr.open("PUT", `${api}/reimbursement/${reimbId}`);

  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4 && xhr.status === 200) {
      console.log("Reimbursement has been updated.");
    } else if (xhr.readyState === 4) {
      console.log("There was a problem. Please try again!");
    }
  };
  xhr.setRequestHeader("Authorization", sessionStorage.token);
  xhr.send(JSON.stringify(payload));
}