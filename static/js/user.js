
     $(".follow-member").click( function(event){
          var memberId = this.getAttribute("member-id");
           var button = this;
            var isFollowed = $(button).hasClass("followed-button");
              debugger;
                   if(isFollowed){
                          $.ajax({
                            type: "POST",
                            url: "/user/un-follow-member",
                            data: this.getAttribute("member-id"),
                            success: function(response){
                                if(!!response){
                                   $(button).removeClass("followed-button");
                                   button.querySelector("span").innerText="follow";
                                }
                            },
                            contentType: 'application/json'
                          });

                      }else{
                              $.ajax({
                               type: "POST",
                               url: "/user/follow-member",
                               data: memberId,
                               success: function(response){
                                   if(!!response){
                                         $(button).addClass("followed-button");
                                        button.querySelector("span").innerText="Followed";
                                   }
                               },
                               contentType: 'application/json'
                             });
                        }
               });
