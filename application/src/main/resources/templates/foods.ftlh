<#import "parts/page.ftlh" as p>

<@p.page title="Foods">
    <div>
        <form action="/add" method="post">
            <input type="text" name="name" placeholder="Name">
            <input type="number" name="cost" placeholder="Cost">
            <input type="text" name="link" placeholder="Link">
            <button type="submit">Add</button>
            ${addMessage!""}
        </form>
    </div>
    <div>
        <form action="/delete" method="post">
            <input type="number" name="id" placeholder="Id">
            <button type="submit">Delete</button>
            ${delMessage!""}
        </form>
    </div>
    <h3>List</h3>
    <div style = "display:flex; flex-direction:column; width: 70%">
	    <#list foods as food>
	    <div style = "display:flex; justify-content:space-between">
	        <div style = "width: 5%">${food.id}</div>
	        <div style = "width: 40%">${food.name}</div>
	        <div style = "width: 15%">${food.cost}</div>
	        <div style = "width: 40%"><a href="${food.link}">${food.link}</a></div>
	    </div>
	    </#list>
    </div>
</@p.page>