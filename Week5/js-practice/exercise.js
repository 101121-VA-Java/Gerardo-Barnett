// Problem 1: Create a function "isWeekday" which takes a single argument and returns true if the argument is a day during the work week. It should return false if it is not.

function isWeekday(input) {
    if(input == "Monday"){
        return true;
    }
    if(input == "Tuesday"){
        return true;
    }
    if(input == "Wednesday"){
        return true;
    }
    if(input == "Thursday"){
        return true;
    }
    if(input == "Friday"){
        return true;
    }
    if(input == "Saturday"){
        return false;
    }
    if(input == "Sunday"){
        return false;
    }
    
}

// Problem 2: Create a function "isEven" which takes a single argument and returns true if the argument is an even integer. It should return false if it is not

function isEven(input) {
    if(input % 2 == 0){
        return true;
    }
    else{
        return false;
    }
    
}

// Problem 3: Write a JavaScript function which takes a single argument and returns the type

function findType(input) {
    
    return;
}

// Problem 4: Write a JavaScript function which takes a single argument and determines if it's prime. If it is, return true. If it's not return false.

function isPrime(input) {
    if (input === 2) {
        return true;
      } else if (input > 1) {
        for (var i = 2; i < input; i++) {
    
          if (input % i !== 0) {
            return true;
          } else if (input === i * i) {
            return false
          } else {
            return false;
          }
        }
      } else {
        return false;
      }

    
}

// Problem 5: Write a JavaScript function which calculates the first number to the power of the second number. Do not do this recursively. Do not use the Math library.

function calculateExponent(base, exponent) {
    return;
}
