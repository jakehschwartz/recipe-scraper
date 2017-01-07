(function(){'use strict';
var e="object"===typeof __ScalaJSEnv&&__ScalaJSEnv?__ScalaJSEnv:{},k="object"===typeof e.global&&e.global?e.global:"object"===typeof global&&global&&global.Object===Object?global:this;e.global=k;var m="object"===typeof e.exportsNamespace&&e.exportsNamespace?e.exportsNamespace:k;e.exportsNamespace=m;k.Object.freeze(e);var n={envInfo:e,semantics:{asInstanceOfs:2,moduleInit:2,strictFloats:!1,productionMode:!0},assumingES6:!1,linkerVersion:"0.6.14"};k.Object.freeze(n);k.Object.freeze(n.semantics);
var p=k.Math.imul||function(a,b){var c=a&65535,d=b&65535;return c*d+((a>>>16&65535)*d+c*(b>>>16&65535)<<16>>>0)|0},q=k.Math.clz32||function(a){if(0===a)return 32;var b=1;0===(a&4294901760)&&(a<<=16,b+=16);0===(a&4278190080)&&(a<<=8,b+=8);0===(a&4026531840)&&(a<<=4,b+=4);0===(a&3221225472)&&(a<<=2,b+=2);return b+(a>>31)},r=0,t=k.WeakMap?new k.WeakMap:null;function v(a){return function(b,c){return!(!b||!b.a||b.a.m!==c||b.a.k!==a)}}function aa(a){for(var b in a)return b}
function w(a,b,c){var d=new a.D(b[c]);if(c<b.length-1){a=a.n;c+=1;for(var g=d.B,f=0;f<g.length;f++)g[f]=w(a,b,c)}return d}function ba(a){switch(typeof a){case "string":return x(y);case "number":var b=a|0;return b===a?b<<24>>24===b&&1/b!==1/-0?x(z):b<<16>>16===b&&1/b!==1/-0?x(A):x(B):"number"===typeof a?x(C):x(D);case "boolean":return x(E);case "undefined":return x(F);default:return null===a?a.Y():a&&a.a&&a.a.h.z?x(ca):a&&a.a?x(a.a):null}}
function da(a){switch(typeof a){case "string":ea||(ea=(new G).e());for(var b=0,c=1,d=-1+(a.length|0)|0;0<=d;)b=b+p(65535&(a.charCodeAt(d)|0),c)|0,c=p(31,c),d=-1+d|0;return b;case "number":H||(H=(new I).e());b=H;c=a|0;if(c===a&&-Infinity!==1/a)b=c;else{if(b.i)b.F[0]=a,b=J(b.t[b.H]|0,b.t[b.G]|0);else{if(a!==a)b=!1,a=2047,c=+k.Math.pow(2,51);else if(Infinity===a||-Infinity===a)b=0>a,a=2047,c=0;else if(0===a)b=-Infinity===1/a,c=a=0;else if(d=(b=0>a)?-a:a,d>=+k.Math.pow(2,-1022)){a=+k.Math.pow(2,52);var c=
+k.Math.log(d)/.6931471805599453,c=+k.Math.floor(c)|0,c=1023>c?c:1023,g=d/+k.Math.pow(2,c)*a,d=+k.Math.floor(g),g=g-d,d=.5>g?d:.5<g?1+d:0!==d%2?1+d:d;2<=d/a&&(c=1+c|0,d=1);1023<c?(c=2047,d=0):(c=1023+c|0,d-=a);a=c;c=d}else a=d/+k.Math.pow(2,-1074),c=+k.Math.floor(a),d=a-c,a=0,c=.5>d?c:.5<d?1+c:0!==c%2?1+c:c;c=+c;b=J(c|0,(b?-2147483648:0)|(a|0)<<20|c/4294967296|0)}b=b.u^b.s}return b;case "boolean":return a?1231:1237;case "undefined":return 0;default:return a&&a.a||null===a?a.y():null===t?42:ga(a)}}
function ha(a,b){var c=k.Object.getPrototypeOf,d=k.Object.getOwnPropertyDescriptor;for(a=c(a);null!==a;){var g=d(a,b);if(void 0!==g)return g;a=c(a)}}function ia(a,b,c){a=ha(a,c);if(void 0!==a)return c=a.get,void 0!==c?c.call(b):a.value}function ja(a,b,c,d){a=ha(a,c);if(void 0!==a&&(a=a.set,void 0!==a)){a.call(b,d);return}throw new k.TypeError("super has no setter '"+c+"'.");}
var ga=null!==t?function(a){switch(typeof a){case "string":case "number":case "boolean":case "undefined":return da(a);default:if(null===a)return 0;var b=t.get(a);void 0===b&&(r=b=r+1|0,t.set(a,b));return b}}:function(a){if(a&&a.a){var b=a.$idHashCode$0;if(void 0!==b)return b;if(k.Object.isSealed(a))return 42;r=b=r+1|0;return a.$idHashCode$0=b}return null===a?0:da(a)};this.__ScalaJSExportsNamespace=m;
function K(){this.v=this.D=void 0;this.k=this.n=this.h=null;this.m=0;this.C=null;this.r="";this.c=this.p=this.q=void 0;this.name="";this.isRawJSType=this.isArrayClass=this.isInterface=this.isPrimitive=!1;this.isInstance=void 0}function L(a,b,c){var d=new K;d.h={};d.n=null;d.C=a;d.r=b;d.c=function(){return!1};d.name=c;d.isPrimitive=!0;d.isInstance=function(){return!1};return d}
function M(a,b,c,d,g,f,l){var h=new K,u=aa(a);f=f||function(a){return!!(a&&a.a&&a.a.h[u])};l=l||function(a,b){return!!(a&&a.a&&a.a.m===b&&a.a.k.h[u])};h.v=g;h.h=c;h.r="L"+b+";";h.c=l;h.name=b;h.isInterface=!1;h.isRawJSType=!!d;h.isInstance=f;return h}
function ka(a){function b(a){if("number"===typeof a){this.B=Array(a);for(var b=0;b<a;b++)this.B[b]=g}else this.B=a}var c=new K,d=a.C,g="longZero"==d?N().w:d;b.prototype=new O;b.prototype.constructor=b;b.prototype.a=c;var d="["+a.r,f=a.k||a,l=a.m+1;c.D=b;c.v=la;c.h={b:1,$:1,d:1};c.n=a;c.k=f;c.m=l;c.C=null;c.r=d;c.q=void 0;c.p=void 0;c.c=void 0;c.name=d;c.isPrimitive=!1;c.isInterface=!1;c.isArrayClass=!0;c.isInstance=function(a){return f.c(a,l)};return c}
function x(a){if(!a.q){var b=new P;b.o=a;a.q=b}return a.q}K.prototype.getFakeInstance=function(){return this===y?"some string":this===E?!1:this===z||this===A||this===B||this===C||this===D?0:this===ca?N().w:this===F?void 0:{a:this}};K.prototype.getSuperclass=function(){return this.v?x(this.v):null};K.prototype.getComponentType=function(){return this.n?x(this.n):null};K.prototype.newArrayOfThisClass=function(a){for(var b=this,c=0;c<a.length;c++)b.p||(b.p=ka(b)),b=b.p;return w(b,a,0)};
var ma=L(!1,"Z","boolean"),na=L(0,"C","char"),oa=L(0,"B","byte"),pa=L(0,"S","short"),qa=L(0,"I","int"),ra=L("longZero","J","long"),sa=L(0,"F","float"),ua=L(0,"D","double");ma.c=v(ma);na.c=v(na);oa.c=v(oa);pa.c=v(pa);qa.c=v(qa);ra.c=v(ra);sa.c=v(sa);ua.c=v(ua);function Q(){}function O(){}O.prototype=Q.prototype;Q.prototype.e=function(){return this};Q.prototype.A=function(){var a=ba(this).o.name,b=(+(this.y()>>>0)).toString(16);return a+"@"+b};Q.prototype.y=function(){return ga(this)};Q.prototype.toString=function(){return this.A()};var la=M({b:0},"java.lang.Object",{b:1},void 0,void 0,function(a){return null!==a},function(a,b){if(a=a&&a.a){var c=a.m||0;return!(c<b)&&(c>b||!a.k.isPrimitive)}return!1});Q.prototype.a=la;
function R(){this.E=this.I=null;this.f=0}R.prototype=new O;R.prototype.constructor=R;R.prototype.e=function(){return this};function S(){var a;T||(T=(new R).e());a=T;0===(268435456&a.f)&&0===(268435456&a.f)&&(0===(134217728&a.f)&&0===(134217728&a.f)&&(a.I=k,a.f|=134217728),a.E=a.I.document,a.f|=268435456);return a.E}R.prototype.a=M({K:0},"org.scalajs.dom.package$",{K:1,b:1});var T=void 0;function P(){this.o=null}P.prototype=new O;P.prototype.constructor=P;
P.prototype.A=function(){return(this.o.isInterface?"interface ":this.o.isPrimitive?"":"class ")+this.o.name};P.prototype.a=M({O:0},"java.lang.Class",{O:1,b:1});function I(){this.i=!1;this.F=this.t=this.l=null;this.x=!1;this.H=this.G=0}I.prototype=new O;I.prototype.constructor=I;
I.prototype.e=function(){H=this;this.l=(this.i=!!(k.ArrayBuffer&&k.Int32Array&&k.Float32Array&&k.Float64Array))?new k.ArrayBuffer(8):null;this.t=this.i?new k.Int32Array(this.l,0,2):null;this.i&&new k.Float32Array(this.l,0,2);this.F=this.i?new k.Float64Array(this.l,0,1):null;if(this.i)this.t[0]=16909060,a=1===((new k.Int8Array(this.l,0,8))[0]|0);else var a=!0;this.G=(this.x=a)?0:1;this.H=this.x?1:0;return this};I.prototype.a=M({U:0},"scala.scalajs.runtime.Bits$",{U:1,b:1});var H=void 0;
function G(){this.f=!1}G.prototype=new O;G.prototype.constructor=G;G.prototype.e=function(){return this};G.prototype.a=M({W:0},"scala.scalajs.runtime.RuntimeString$",{W:1,b:1});var ea=void 0;function U(){}U.prototype=new O;U.prototype.constructor=U;U.prototype.e=function(){return this};U.prototype.main=function(){var a=S().body,b=S().createElement("p"),c=S().createTextNode("Hello World");b.appendChild(c);a.appendChild(b)};U.prototype.a=M({J:0},"com.schwartz.scraper.Scraper$",{J:1,b:1,ba:1});
var V=void 0;m.com=m.com||{};m.com.schwartz=m.com.schwartz||{};m.com.schwartz.scraper=m.com.schwartz.scraper||{};m.com.schwartz.scraper.Scraper=function(){V||(V=(new U).e());return V};function W(){}W.prototype=new O;W.prototype.constructor=W;function va(){}va.prototype=W.prototype;var F=M({X:0},"scala.runtime.BoxedUnit",{X:1,b:1,d:1},void 0,void 0,function(a){return void 0===a}),E=M({M:0},"java.lang.Boolean",{M:1,b:1,d:1,g:1},void 0,void 0,function(a){return"boolean"===typeof a});
function X(){this.w=null}X.prototype=new O;X.prototype.constructor=X;X.prototype.e=function(){Y=this;this.w=J(0,0);return this};
function wa(a,b){if(0===(-2097152&b))b=""+(4294967296*b+ +(a>>>0));else{var c=(32+q(1E9)|0)-(0!==b?q(b):32+q(a)|0)|0,d=c,g=0===(32&d)?1E9<<d:0,d=0===(32&d)?5E8>>>(31-d|0)|0|0<<d:1E9<<d,f=a,l=b;for(a=b=0;0<=c&&0!==(-2097152&l);){var h=f,u=l,ta=g,fa=d;if(u===fa?(-2147483648^h)>=(-2147483648^ta):(-2147483648^u)>=(-2147483648^fa))h=l,u=d,l=f-g|0,h=(-2147483648^l)>(-2147483648^f)?-1+(h-u|0)|0:h-u|0,f=l,l=h,32>c?b|=1<<c:a|=1<<c;c=-1+c|0;h=d>>>1|0;g=g>>>1|0|d<<31;d=h}c=l;if(0===c?-1147483648<=(-2147483648^
f):-2147483648<=(-2147483648^c))c=4294967296*l+ +(f>>>0),f=c/1E9,g=f/4294967296|0,d=b,b=f=d+(f|0)|0,a=(-2147483648^f)<(-2147483648^d)?1+(a+g|0)|0:a+g|0,f=c%1E9|0;c=""+f;b=""+(4294967296*a+ +(b>>>0))+"000000000".substring(c.length|0)+c}return b}X.prototype.a=M({V:0},"scala.scalajs.runtime.RuntimeLong$",{V:1,b:1,aa:1,d:1});var Y=void 0;function N(){Y||(Y=(new X).e());return Y}
var y=M({L:0},"java.lang.String",{L:1,b:1,d:1,Z:1,g:1},void 0,void 0,function(a){return"string"===typeof a}),z=M({N:0},"java.lang.Byte",{N:1,j:1,b:1,d:1,g:1},void 0,void 0,function(a){return a<<24>>24===a&&1/a!==1/-0}),D=M({P:0},"java.lang.Double",{P:1,j:1,b:1,d:1,g:1},void 0,void 0,function(a){return"number"===typeof a}),C=M({Q:0},"java.lang.Float",{Q:1,j:1,b:1,d:1,g:1},void 0,void 0,function(a){return"number"===typeof a}),B=M({R:0},"java.lang.Integer",{R:1,j:1,b:1,d:1,g:1},void 0,void 0,function(a){return(a|
0)===a&&1/a!==1/-0}),ca=M({S:0},"java.lang.Long",{S:1,j:1,b:1,d:1,g:1},void 0,void 0,function(a){return!!(a&&a.a&&a.a.h.z)}),A=M({T:0},"java.lang.Short",{T:1,j:1,b:1,d:1,g:1},void 0,void 0,function(a){return a<<16>>16===a&&1/a!==1/-0});function Z(){this.s=this.u=0}Z.prototype=new va;Z.prototype.constructor=Z;Z.prototype.A=function(){N();var a=this.u,b=this.s;return b===a>>31?""+a:0>b?"-"+wa(-a|0,0!==a?~b:-b|0):wa(a,b)};function J(a,b){var c=new Z;c.u=a;c.s=b;return c}
Z.prototype.y=function(){return this.u^this.s};Z.prototype.a=M({z:0},"scala.scalajs.runtime.RuntimeLong",{z:1,j:1,b:1,d:1,g:1});
}).call(this);
//# sourceMappingURL=recipe-scraper-opt.js.map
