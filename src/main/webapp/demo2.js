 //Observe: no return type, no type on parameters
 
 //Opg2
function add(n1, n2){
   return n1 +n2;
}

function mul(n1, n2){
   return n1 * n2;
}

var sub = function(n1,n2){
  return n1 - n2;
};

var cb = function(n1,n2, callback){
    try {
  return "Result from the two numbers: "+n1+" and "+n2+" = "+callback(n1,n2);
  throw new Error('Whoops!');
    }
    catch (e) {
        typeof n1 === "number";
        typeof n2 === "number";
        typeof callback === "function";
        
        console.error(e.name + ': ' + e.message);
    }
};
//1
//console.log( add(1,2) );

//2
//console.log( add );

//3
//console.log( add(1,2,3) ) ;

//4
//console.log( add(1) );	

//5
console.log( cb(3,3,add) );

//6
console.log( cb(4,3,sub) );

//7
//console.log(cb(3,3,add()));

//console.log(cb(3,"hh",add));

console.log( cb(3,3,mul) );


