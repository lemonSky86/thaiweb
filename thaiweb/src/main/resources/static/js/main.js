/**
 * @Description //检查用户状态
 * @Param
 * @Author oneTi
 * @Date 15:32 2018/8/10
 * @Return
 **/
function checkUserStatus()
{
    $.ajax({
        async:false,
        url:"/user/status/",
        success:function (result) {
            if (result != null)
            {
                // $("#userName").text(result.userName);
                var userInfoLabel = "<li><a href='#' class='navbar-link' id='userName'>"+ result.userName +"</a></li>";
                var signOutLabel = "<li><a href='/user/login/out' class='navbar-link' id='sign-out'>Sign Out</a></li>";
                $("#login-box").html(userInfoLabel+signOutLabel);
            }
        }
    })
}