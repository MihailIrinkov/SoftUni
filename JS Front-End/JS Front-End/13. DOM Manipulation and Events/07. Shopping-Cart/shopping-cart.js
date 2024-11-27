document.addEventListener('DOMContentLoaded', solve);

function solve() {
   
   const resulEl = document.querySelector('textarea[disabled]');
   const checkoutBtnEl = document.querySelector('button.checkout');
   const prodCatalogEl = document.querySelector('.shopping-cart');

   const products = {};

   prodCatalogEl.addEventListener('click', e => {
      if (e.target.nodeName != 'BUTTON') return;

      switch (e.target.getAttribute('class')) {

         case 'add-product':
         const productEl = e.target.closest('.product');
         // const productEl = e.target.parentElement.parentElement;
         const name = productEl.querySelector('.product-title').textContent;
         const price = Number(productEl.querySelector('.product-line-price').textContent);

         resulEl.value += `Added ${name} for ${price.toFixed(2)} to the cart.\n`;

         if (!products.hasOwnProperty(name)) products[name] = 0;
         // products[name] ??= 0;
         products[name] += price;

            break;

         case 'checkout':
            const productNames = Object.keys(products);
            const totalPrice = productNames.reduce((price, name) => price + products[name], 0);

            resulEl.value += `You bought ${productNames.join(', ')} for ${totalPrice.toFixed(2)}.`;
            prodCatalogEl.querySelectorAll('button').forEach(el => el.setAttribute('disabled', 'disabled'));
            
            break;
      }

   });
}
