//0909
//Filter,Map,ForEach
//Opg 1
var boys = ["Peter", "Hans", "Ole","Lars", "Jan", "Bo", "Frederik"];

const result = boys.filter(boy => boy.length > 3);

boys.forEach(element => console.log(element));

result.forEach(element => console.log(element));

//Opg 2
var mapped = boys.map(function(el, i) {
  return { index: i, value: el.toUpperCase() };
});

console.log(mapped);

//Opg 3
let list = boys.map(function(name){
    return "<li>"+name+"</li>";
});
let listAsString = "<ul>" + list.join("") + "<ul>";
//var boys2 = boys.join('</li><li>');

//console.log(boys2);

//console.log(boys2);

//boys2.unshift('<ul>','<li>');

//boys2.push('</li>','<ul>');

console.log(listAsString);

//console.log(boys.join('</li><li>'));



