 let layer = prompt("==층수를 입력하세요==");
        for (let i = 1; i <= layer; i++) {
            for (let j = 1; j < layer-i; j++) {
               console.log(" ");
            }
            for (let j = 1; j <= 2*i-1; j++) {
                console.log("*");
            }
            console.log("\n");

        }