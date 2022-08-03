window.onload = function () {
    var vue = new Vue({
        el: "#cart_div",
        data: {
            cart:{}
        },
        methods: {
            getCart: function () {
                axios({
                    method: "POST",
                    url: "cart.do",
                    params: {
                        operate: "cartInfo"
                    }
                }).then(function (value) {
                    // console.log(value.data);
                    var cart = value.data;
                    vue.cart = cart;

                }).catch(function (reason) {

                })
            },
            editCartItem:function (cartItemId,buyCount) {
                axios({
                    methods: "POST",
                    url: "cart.do",
                    params: {
                        operate:'editCart',
                        cartItemId:cartItemId,
                        buyCount:buyCount
                    }
                }).then(function (value) {
                    vue.getCart();
                }).catch(function (reason) {

                })
            },
            delCartItem:function (cartItemId) {
                axios({
                    methods:"POST",
                    url:"cart.do",
                    params: {
                        operate:'delCart',
                        cartItemId:cartItemId,
                    }
                }).then(function (value) {
                    vue.getCart();
                }).catch(function (error) {

                })
            }
        },
        mounted:function(){
            this.getCart() ;
        }
    });
}