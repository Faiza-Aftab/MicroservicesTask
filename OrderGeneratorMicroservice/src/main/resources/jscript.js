function callme(){
//This promise will resolve when the network call succeeds
//Feel free to make a REST fetch using promises and assign it to networkPromise
var networkPromise = fetch('https://jsonplaceholder.typicode.com/todos/1');


//This promise will resolve when 2 seconds have passed
var timeOutPromise = new Promise(function(resolve, reject) {
  // 2 Second delay
  setTimeout(resolve, 2000, 'Timeout Done');
});

Promise.all(
[networkPromise, timeOutPromise]).then(function(values) {
  console.log("Atleast 2 secs + TTL (Network/server)");
  //Repeat
  callme();
});
}


///////////////////
const getMachineAction = async () => {
    try {
        const response = await fetch( 'https://localhost:55620/api/machine/');
        if (response.status === 200) {
            console.log("Machine successfully found.");
            const myJson = await response.json(); //extract JSON from the http response
            console.log(myJson);               
        } else {
            console.log("not a 200");
        }
    } catch (err) {
        // catches errors both in fetch and response.json
        console.log(err);
    } finally {
        // do it again in 2 seconds
        setTimeout(getMachineAction , 2000);
    }
};

getMachineAction()
