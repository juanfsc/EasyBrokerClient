document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.slider');
    var options = {indicators:true, duration:500, interval:6000};
    var instances = M.Slider.init(elems, options);
});

document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.carousel');
    var instances = M.Carousel.init(elems, {
        fullWidth: true,
        indicators: true
    });
});

const contactForm = document.getElementById('contactForm');
contactForm.addEventListener('submit', async function (e) {
    e.preventDefault();
    var form = {
        email:document.getElementById('email').value,
        phone:document.getElementById('phone').value,
        name:document.getElementById('name').value,
        message:document.getElementById('message').value,
        property_id:document.getElementById('public_id').innerText,
        source: "mydomain.com"
    }
    console.log(JSON.stringify(form))
    const response = await fetch('/contact', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(form)
    });
});

