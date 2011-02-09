/* Simple JavaScript Inheritance
 * By John Resig http://ejohn.org/
 * MIT Licensed.
 */
// Inspired by base2 and Prototype
(function(){
  var initializing = false, fnTest = /xyz/.test(function(){xyz;}) ? /\b_super\b/ : /.*/;
  // The base Class implementation (does nothing)
  this.Class = function(){};
  
  // Create a new Class that inherits from this class
  Class.extend = function(prop) {
    var _super = this.prototype;
    
    // Instantiate a base class (but only create the instance,
    // don't run the init constructor)
    initializing = true;
    var prototype = new this();
    initializing = false;
    
    // Copy the properties over onto the new prototype
    for (var name in prop) {
      // Check if we're overwriting an existing function
      prototype[name] = typeof prop[name] == "function" && 
        typeof _super[name] == "function" && fnTest.test(prop[name]) ?
        (function(name, fn){
          return function() {
            var tmp = this._super;
            
            // Add a new ._super() method that is the same method
            // but on the super-class
            this._super = _super[name];
            
            // The method only need to be bound temporarily, so we
            // remove it when we're done executing
            var ret = fn.apply(this, arguments);        
            this._super = tmp;
            
            return ret;
          };
        })(name, prop[name]) :
        prop[name];
    }
    
    // The dummy class constructor
    function Class() {
      // All construction is actually done in the init method
      if ( !initializing && this.init )
        this.init.apply(this, arguments);
    }
    
    // Populate our constructed prototype object
    Class.prototype = prototype;
    
    // Enforce the constructor to be what we expect
    Class.constructor = Class;

    // And make this class extendable
    Class.extend = arguments.callee;
    
    return Class;
  };
})();

Array.prototype.remove = function(element){
    if((id = this.indexOf(element)) != -1)
        this.splice(id, 1);
}


//more resig magic:
Function.prototype.partial = function(){
var fn = this, args = Array.prototype.slice.call(arguments);
return function(){
  var arg = 0;
  for ( var i = 0; i < args.length && arg < arguments.length; i++ )
    if ( args[i] === undefined )
      args[i] = arguments[arg++];
  return fn.apply(this, args);
};
};


//the jurassic world
var LivingBeing = Class.extend({
    init: function(mass, name){
            this.mass = mass;
            this.name = name || "Ser Vivo";
          },
    inspect: function(){
                return this.name+", de "+this.mass+" libras";
             }
});

var Dinosaur = LivingBeing.extend({
    init: function(m,n,op){this._super(m, n || "Dinosaur"); this.eating_op = op;}
   ,eat: function(l,b){
        this.mass = this.eating_op(this.mass, b);
        l.remove(b);
    }
});

var Plant = LivingBeing.extend({
    init: function(m){this._super(m, "Plant");}
});

var Carnivore = Dinosaur.extend({
    hunt: function(l){
        var self = this;
        return l.filter(function(being){
            return being instanceof Dinosaur && being != self;
        })[0];
    }
});

var Herbivore = Dinosaur.extend({
   hunt: function(l){
        return l.filter(function(being){
            return being instanceof Plant;
        })[0];
   }
});

var TRex = Carnivore.extend({
    init: function(m){this._super(m, "TRex", function(b,o){return b+o.mass;});}
});

var Utahraptor= Carnivore.extend({
    init: function(m){this._super(m, "Utahraptor", function(b,o){return b*o.mass*o.mass;});}
});

var Dromiceiomimus = Herbivore.extend({
    init: function(m){this._super(m, "Dromiceiomimus", function(b,o){return b+o.mass/2;});}
});

ecosystem = [];
classes = [TRex, Utahraptor, Dromiceiomimus, Plant];
for(var i=0;i<10;i++){
    e = new classes[Math.floor(Math.random()*4)](Math.floor(Math.random()*30));
    if(e['hunt'] !== undefined)
        e.hunt = e.hunt.partial(ecosystem);
    if(e['eat'] !== undefined)
        e.eat = e.eat.partial(ecosystem, undefined);
    ecosystem.push(e);
}