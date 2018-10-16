function flip() {
  return Math.random() >= 0.5;
}

function randomNumber(n) {
  if(n === undefined) throw new Error("n is required");
  if(n <= 0) throw new Error("n must be greater than 0");
  if(n > 1000000) throw new Error("n must be lower than 1,000,000");
  
  if(n === 1) return 0;
  
  // Get the maximum posible value (n - 1)
  var maxPosibleValue = n-1;
  
  // Calculate the maximum posible value express as binary
  var maxPosibleBinary = maxPosibleValue.toString(2).length;
  
  var r;
  do {
    // Get the random number as Int
    r = parseInt(randomBinary(maxPosibleBinary), 2);
    // check if meets the maximum posible value
  } while (r > maxPosibleValue);
  
  return r;
}

// Returns a string of random 0s and 1s with length m
function randomBinary(m){
  binary = "";
  for (var i=0; i<m; i++) {
    binary += flip()? "1" : "0";
  }
    
  return binary;
}
  
randomNumber(500); // returns 123
randomNumber(1); // returns 0
randomNumber(500); // returns 466
randomNumber(1000001); // throw error