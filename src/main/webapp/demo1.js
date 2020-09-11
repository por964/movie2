
//Opg a
var boys = ["Peter", "lars", "Ole"];
var girls = ["Janne", "hanne", "Sanne"];

console.log(boys);
//Opg b
const all = boys.concat(girls);

console.log(all);

//Opg c
console.log(all.join());

console.log(all.join('-'));

//Opg d
let all2 = all.push('Lone', 'Gitte');

//Opg e
let all3 = all.unshift('Hans','Kurt');

console.log(all);
//Opg f
all.shift();

//Opg g
all.pop();

console.log(all);

//Opg h
all.splice(3,2);

console.log(all);

//Opg i
all.reverse();

console.log(all);

//Opg j
all.sort();

console.log(all);

//Opg k
// temporary array holds objects with position and sort-value
var mapped = all.map(function(el, i) {
  return { index: i, value: el.toLowerCase() };
})

// sorting the mapped array containing the reduced values
mapped.sort(function(a, b) {
  if (a.value > b.value) {
    return 1;
  }
  if (a.value < b.value) {
    return -1;
  }
  return 0;
});

// container for the resulting order
var result = mapped.map(function(el){
  return all[el.index];
});

//Opg L
const uppercased = all.map(name => name.toUpperCase());

console.log(uppercased);

//Opg m
const startK = all.filter((name) => name.startsWith("K"));
const startP = all.filter((name) => name.startsWith("P"));

const kp = startK.concat(startP);

console.log(kp);



