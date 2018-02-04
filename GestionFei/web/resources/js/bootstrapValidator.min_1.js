/**
 * BootstrapValidator v0.2.3 (http://github.com/nghuuphuoc/bootstrapvalidator)
 *
 * A jQuery plugin to validate form fields. Use with Bootstrap 3
 *
 * @author      Nguyen Huu Phuoc <phuoc@huuphuoc.me>
 * @copyright   (c) 2013 Nguyen Huu Phuoc
 * @license     MIT
 */

!function(a){var b=function(c,d){this.$form=a(c),this.options=a.extend({},b.DEFAULT_OPTIONS,d),"disabled"==this.options.live&&(this.options.submitButtons=null),this.invalidFields={},this.xhrRequests={},this.numPendingRequests=null,this.formSubmited=!1,this.submitHandlerCalled=!1,this._init()};b.DEFAULT_OPTIONS={elementClass:"bootstrap-validator-form",message:"This value is not valid",submitButtons:'button[type="submit"]',submitHandler:null,live:"enabled",fields:null},b.prototype={constructor:b,_init:function(){if(null!=this.options.fields){var a=this;this.$form.attr("novalidate","novalidate").addClass(this.options.elementClass).on("submit",function(b){if(a.formSubmited=!0,a.options.fields){for(var c in a.options.fields)if(a.numPendingRequests>0||null==a.numPendingRequests){var d=a.getFieldElement(c);d&&d.data("bootstrapValidator.isValid")!==!0&&a.validateField(c)}if(a.isValid()){if(!a.submitHandlerCalled&&a.options.submitHandler&&"function"==typeof a.options.submitHandler)return a.submitHandlerCalled=!0,a.options.submitHandler.call(a,a,a.$form),!1}else{a.$form.find(a.options.submitButtons).attr("disabled","disabled"),"submitted"==a.options.live&&(a.options.live="enabled",a._setLiveValidating());for(var e in a.invalidFields){a.getFieldElement(e).focus();break}b.preventDefault()}}});for(var b in this.options.fields)this._initField(b);this._setLiveValidating()}},_setLiveValidating:function(){if("enabled"==this.options.live){var b=this;this.options.live="disabled";for(var c in this.options.fields)!function(c){var d=b.getFieldElements(c);if(d&&d.length>0){var e=a(d[0]),f=e.attr("type");if("radio"==f){var g="change";d.on(g,function(){b.formSubmited=!1,b.validateField(c)})}else{var g="checkbox"==f||"SELECT"==e.get(0).tagName?"change":"keyup";e.on(g,function(){b.formSubmited=!1,b.validateField(c)})}}}(c)}},_initField:function(b){if(null!=this.options.fields[b]&&null!=this.options.fields[b].validators){var c=this.getFieldElement(b);if(null!=c){var d=c.parents(".form-group"),e=d.find(".help-block");if(0==e.length){var f=a("<small/>").addClass("help-block").css("display","none").appendTo(d);c.data("bootstrapValidator.error",f);var g,h,i,j;if(g=d.find("label").get(0)){if(h=a(g).attr("class")){h=h.split(" ");for(var k=0;k<h.length;k++)if(/^col-(xs|sm|md|lg)-\d+$/.test(h[k])){i=h[k].substr(7),j=h[k].substr(4,2);break}}}else if(h=d.children().eq(0).attr("class")){h=h.split(" ");for(var k=0;k<h.length;k++)if(/^col-(xs|sm|md|lg)-offset-\d+$/.test(h[k])){i=h[k].substr(14),j=h[k].substr(4,2);break}}j&&i&&f.addClass(["col-",j,"-offset-",i].join("")).addClass(["col-",j,"-",12-i].join(""))}else c.data("bootstrapValidator.error",e.eq(0))}}},getFieldElement:function(b){var c=this.$form.find('[name="'+b+'"]');return 0==c.length?null:a(c[0])},getFieldElements:function(a){var b=this.$form.find('[name="'+a+'"]');return 0==b.length?null:b},validateField:function(b){var c=this.getFieldElement(b);if(null!=c){var d=this,e=d.options.fields[b].validators;for(var f in e)if(a.fn.bootstrapValidator.validators[f]){var g=a.fn.bootstrapValidator.validators[f].validate(d,c,e[f]);if(g===!1){d.showError(c,f);break}g===!0&&d.removeError(c)}}},showError:function(a,b){var c=a.attr("name"),d=this.options.fields[c].validators[b],e=d.message||this.options.message,f=a.parents(".form-group");this.invalidFields[c]=!0,f.removeClass("has-success").addClass("has-error"),a.data("bootstrapValidator.error").html(e).show(),this.$form.find(this.options.submitButtons).attr("disabled","disabled")},removeError:function(a){delete this.invalidFields[a.attr("name")],a.parents(".form-group").removeClass("has-error").addClass("has-success"),a.data("bootstrapValidator.error").hide(),this.$form.find(this.options.submitButtons).removeAttr("disabled")},startRequest:function(a,b,c){var d=a.attr("name");a.data("bootstrapValidator.isValid",!1),this.$form.find(this.options.submitButtons).attr("disabled","disabled"),null==this.numPendingRequests&&(this.numPendingRequests=0),this.numPendingRequests++,this.xhrRequests[d]||(this.xhrRequests[d]={}),this.xhrRequests[d][b]&&(this.numPendingRequests--,this.xhrRequests[d][b].abort()),this.xhrRequests[d][b]=c},completeRequest:function(a,b,c){c===!1?this.showError(a,b):c===!0&&(this.removeError(a),a.data("bootstrapValidator.isValid",!0));var d=a.attr("name");delete this.xhrRequests[d][b],this.numPendingRequests--,this.numPendingRequests<=0&&(this.numPendingRequests=0,this.formSubmited&&(!this.submitHandlerCalled&&this.options.submitHandler&&"function"==typeof this.options.submitHandler?(this.submitHandlerCalled=!0,this.options.submitHandler.call(this,this,this.$form)):this.$form.submit()))},isValid:function(){if(this.numPendingRequests>0)return!1;for(var a in this.invalidFields)if(this.invalidFields[a]&&!this.getFieldElement(a).is(":disabled"))return!1;return!0}},a.fn.bootstrapValidator=function(c){return this.each(function(){var d=a(this),e=d.data("bootstrapValidator");e||d.data("bootstrapValidator",e=new b(this,c))})},a.fn.bootstrapValidator.validators={},a.fn.bootstrapValidator.Constructor=b}(window.jQuery),function(a){a.fn.bootstrapValidator.validators.between={validate:function(a,b,c){var d=b.val();return""==d?!0:(d=parseFloat(d),c.inclusive===!0?d>c.min&&d<c.max:d>=c.min&&d<=c.max)}}}(window.jQuery),function(a){a.fn.bootstrapValidator.validators.callback={validate:function(a,b,c){var d=b.val();return c.callback&&"function"==typeof c.callback?c.callback.call(this,d,this):!0}}}(window.jQuery),function(a){a.fn.bootstrapValidator.validators.creditCard={validate:function(a,b){var c=b.val();if(""==c)return!0;if(/[^0-9-\s]+/.test(c))return!1;c=c.replace(/\D/g,"");for(var d=0,e=0,f=!1,g=c.length,h=g-1;h>=0;h--)e=parseInt(c.charAt(h),10),f&&(e*=2)>9&&(e-=9),d+=e,f=!f;return d%10==0}}}(window.jQuery),function(a){a.fn.bootstrapValidator.validators.different={validate:function(a,b,c){var d=b.val();if(""==d)return!0;var e=a.getFieldElement(c.field);return e&&d!=e.val()?(a.removeError(e),!0):!1}}}(window.jQuery),function(a){a.fn.bootstrapValidator.validators.digits={validate:function(a,b){var c=b.val();return""==c?!0:/^\d+$/.test(c)}}}(window.jQuery),function(a){a.fn.bootstrapValidator.validators.emailAddress={validate:function(a,b){var c=b.val();if(""==c)return!0;var d=/^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;return d.test(c)}}}(window.jQuery),function(a){a.fn.bootstrapValidator.validators.greaterThan={validate:function(a,b,c){var d=b.val();return""==d?!0:(d=parseFloat(d),c.inclusive===!0?d>c.value:d>=c.value)}}}(window.jQuery),function(a){a.fn.bootstrapValidator.validators.hexColor={validate:function(a,b){var c=b.val();return""==c?!0:/(^#[0-9A-F]{6}$)|(^#[0-9A-F]{3}$)/i.test(c)}}}(window.jQuery),function(a){a.fn.bootstrapValidator.validators.identical={validate:function(a,b,c){var d=b.val();if(""==d)return!0;var e=a.getFieldElement(c.field);return e&&d==e.val()?(a.removeError(e),!0):!1}}}(window.jQuery),function(a){a.fn.bootstrapValidator.validators.lessThan={validate:function(a,b,c){var d=b.val();return""==d?!0:(d=parseFloat(d),c.inclusive===!0?d<c.value:d<=c.value)}}}(window.jQuery),function(a){a.fn.bootstrapValidator.validators.notEmpty={validate:function(b,c){var d=c.attr("type");if("radio"==d){var e="input[name="+c.attr("name")+"]:checked";return a(e).length>0}return"checkbox"==d?c.is(":checked"):""!=a.trim(c.val())}}}(window.jQuery),function(a){a.fn.bootstrapValidator.validators.regexp={validate:function(a,b,c){var d=b.val();return""==d?!0:c.regexp.test(d)}}}(window.jQuery),function(a){a.fn.bootstrapValidator.validators.remote={validate:function(b,c,d){var e=c.val();if(""==e)return!0;var f=c.attr("name"),g=d.data;null==g&&(g={}),g[f]=e;var h=a.ajax({type:"POST",url:d.url,dataType:"json",data:g}).success(function(a){var d=a.valid===!0||"true"===a.valid;b.completeRequest(c,"remote",d)});return b.startRequest(c,"remote",h),"pending"}}}(window.jQuery),function(a){a.fn.bootstrapValidator.validators.stringLength={validate:function(b,c,d){var e=c.val();if(""==e)return!0;var f=a.trim(e).length;return d.min&&f<d.min||d.max&&f>d.max?!1:!0}}}(window.jQuery),function(a){a.fn.bootstrapValidator.validators.uri={validate:function(a,b){var c=b.val();if(""==c)return!0;var d=new RegExp("^(?:(?:https?|ftp)://)(?:\\S+(?::\\S*)?@)?(?:(?!10(?:\\.\\d{1,3}){3})(?!127(?:\\.\\d{1,3}){3})(?!169\\.254(?:\\.\\d{1,3}){2})(?!192\\.168(?:\\.\\d{1,3}){2})(?!172\\.(?:1[6-9]|2\\d|3[0-1])(?:\\.\\d{1,3}){2})(?:[1-9]\\d?|1\\d\\d|2[01]\\d|22[0-3])(?:\\.(?:1?\\d{1,2}|2[0-4]\\d|25[0-5])){2}(?:\\.(?:[1-9]\\d?|1\\d\\d|2[0-4]\\d|25[0-4]))|(?:(?:[a-z\\u00a1-\\uffff0-9]+-?)*[a-z\\u00a1-\\uffff0-9]+)(?:\\.(?:[a-z\\u00a1-\\uffff0-9]+-?)*[a-z\\u00a1-\\uffff0-9]+)*(?:\\.(?:[a-z\\u00a1-\\uffff]{2,})))(?::\\d{2,5})?(?:/[^\\s]*)?$","i");return d.test(c)}}}(window.jQuery),function(a){a.fn.bootstrapValidator.validators.usZipCode={validate:function(a,b){var c=b.val();return""==c?!0:/^\d{5}([\-]\d{4})?$/.test(c)}}}(window.jQuery);