import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Forum from '../pages/forum/list'
import ForumAdd from '../pages/forum/add'
import ForumDetail from '../pages/forum/detail'
import MyForumList from '../pages/forum/myForumList'
import Storeup from '../pages/storeup/list'
import AddrList from '../pages/shop-address/list'
import AddrAdd from '../pages/shop-address/addOrUpdate'
import Order from '../pages/shop-order/list'
import OrderConfirm from '../pages/shop-order/confirm'
import Cart from '../pages/shop-cart/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import yangshengfenleiList from '../pages/yangshengfenlei/list'
import yangshengfenleiDetail from '../pages/yangshengfenlei/detail'
import yangshengfenleiAdd from '../pages/yangshengfenlei/add'
import chanpinfenleiList from '../pages/chanpinfenlei/list'
import chanpinfenleiDetail from '../pages/chanpinfenlei/detail'
import chanpinfenleiAdd from '../pages/chanpinfenlei/add'
import yinshileixingList from '../pages/yinshileixing/list'
import yinshileixingDetail from '../pages/yinshileixing/detail'
import yinshileixingAdd from '../pages/yinshileixing/add'
import yangshengtuijianList from '../pages/yangshengtuijian/list'
import yangshengtuijianDetail from '../pages/yangshengtuijian/detail'
import yangshengtuijianAdd from '../pages/yangshengtuijian/add'
import yangshengwenzhangList from '../pages/yangshengwenzhang/list'
import yangshengwenzhangDetail from '../pages/yangshengwenzhang/detail'
import yangshengwenzhangAdd from '../pages/yangshengwenzhang/add'
import yangshengzhishiList from '../pages/yangshengzhishi/list'
import yangshengzhishiDetail from '../pages/yangshengzhishi/detail'
import yangshengzhishiAdd from '../pages/yangshengzhishi/add'
import yangshengfenxiangList from '../pages/yangshengfenxiang/list'
import yangshengfenxiangDetail from '../pages/yangshengfenxiang/detail'
import yangshengfenxiangAdd from '../pages/yangshengfenxiang/add'
import tizhiceshiList from '../pages/tizhiceshi/list'
import tizhiceshiDetail from '../pages/tizhiceshi/detail'
import tizhiceshiAdd from '../pages/tizhiceshi/add'
import sijiyangshengList from '../pages/sijiyangsheng/list'
import sijiyangshengDetail from '../pages/sijiyangsheng/detail'
import sijiyangshengAdd from '../pages/sijiyangsheng/add'
import yangshengchanpinList from '../pages/yangshengchanpin/list'
import yangshengchanpinDetail from '../pages/yangshengchanpin/detail'
import yangshengchanpinAdd from '../pages/yangshengchanpin/add'
import sijifenleiList from '../pages/sijifenlei/list'
import sijifenleiDetail from '../pages/sijifenlei/detail'
import sijifenleiAdd from '../pages/sijifenlei/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import aboutusList from '../pages/aboutus/list'
import aboutusDetail from '../pages/aboutus/detail'
import aboutusAdd from '../pages/aboutus/add'
import systemintroList from '../pages/systemintro/list'
import systemintroDetail from '../pages/systemintro/detail'
import systemintroAdd from '../pages/systemintro/add'
import discussyangshengtuijianList from '../pages/discussyangshengtuijian/list'
import discussyangshengtuijianDetail from '../pages/discussyangshengtuijian/detail'
import discussyangshengtuijianAdd from '../pages/discussyangshengtuijian/add'
import discussyangshengwenzhangList from '../pages/discussyangshengwenzhang/list'
import discussyangshengwenzhangDetail from '../pages/discussyangshengwenzhang/detail'
import discussyangshengwenzhangAdd from '../pages/discussyangshengwenzhang/add'
import discussyangshengzhishiList from '../pages/discussyangshengzhishi/list'
import discussyangshengzhishiDetail from '../pages/discussyangshengzhishi/detail'
import discussyangshengzhishiAdd from '../pages/discussyangshengzhishi/add'
import discussyangshengfenxiangList from '../pages/discussyangshengfenxiang/list'
import discussyangshengfenxiangDetail from '../pages/discussyangshengfenxiang/detail'
import discussyangshengfenxiangAdd from '../pages/discussyangshengfenxiang/add'
import discusssijiyangshengList from '../pages/discusssijiyangsheng/list'
import discusssijiyangshengDetail from '../pages/discusssijiyangsheng/detail'
import discusssijiyangshengAdd from '../pages/discusssijiyangsheng/add'
import discussyangshengchanpinList from '../pages/discussyangshengchanpin/list'
import discussyangshengchanpinDetail from '../pages/discussyangshengchanpin/detail'
import discussyangshengchanpinAdd from '../pages/discussyangshengchanpin/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'forum',
					component: Forum
				},
				{
					path: 'forumAdd',
					component: ForumAdd
				},
				{
					path: 'forumDetail',
					component: ForumDetail
				},
				{
					path: 'myForumList',
					component: MyForumList
				},
				{
					path: 'storeup',
					component: Storeup
				},
                {
                    path: 'shop-address/list',
                    component: AddrList
                },
                {
                    path: 'shop-address/addOrUpdate',
                    component: AddrAdd
                },
				{
					path: 'shop-order/order',
					component: Order
				},
				{
					path: 'cart',
					component: Cart
				},
				{
					path: 'shop-order/orderConfirm',
					component: OrderConfirm
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'yangshengfenlei',
					component: yangshengfenleiList
				},
				{
					path: 'yangshengfenleiDetail',
					component: yangshengfenleiDetail
				},
				{
					path: 'yangshengfenleiAdd',
					component: yangshengfenleiAdd
				},
				{
					path: 'chanpinfenlei',
					component: chanpinfenleiList
				},
				{
					path: 'chanpinfenleiDetail',
					component: chanpinfenleiDetail
				},
				{
					path: 'chanpinfenleiAdd',
					component: chanpinfenleiAdd
				},
				{
					path: 'yinshileixing',
					component: yinshileixingList
				},
				{
					path: 'yinshileixingDetail',
					component: yinshileixingDetail
				},
				{
					path: 'yinshileixingAdd',
					component: yinshileixingAdd
				},
				{
					path: 'yangshengtuijian',
					component: yangshengtuijianList
				},
				{
					path: 'yangshengtuijianDetail',
					component: yangshengtuijianDetail
				},
				{
					path: 'yangshengtuijianAdd',
					component: yangshengtuijianAdd
				},
				{
					path: 'yangshengwenzhang',
					component: yangshengwenzhangList
				},
				{
					path: 'yangshengwenzhangDetail',
					component: yangshengwenzhangDetail
				},
				{
					path: 'yangshengwenzhangAdd',
					component: yangshengwenzhangAdd
				},
				{
					path: 'yangshengzhishi',
					component: yangshengzhishiList
				},
				{
					path: 'yangshengzhishiDetail',
					component: yangshengzhishiDetail
				},
				{
					path: 'yangshengzhishiAdd',
					component: yangshengzhishiAdd
				},
				{
					path: 'yangshengfenxiang',
					component: yangshengfenxiangList
				},
				{
					path: 'yangshengfenxiangDetail',
					component: yangshengfenxiangDetail
				},
				{
					path: 'yangshengfenxiangAdd',
					component: yangshengfenxiangAdd
				},
				{
					path: 'tizhiceshi',
					component: tizhiceshiList
				},
				{
					path: 'tizhiceshiDetail',
					component: tizhiceshiDetail
				},
				{
					path: 'tizhiceshiAdd',
					component: tizhiceshiAdd
				},
				{
					path: 'sijiyangsheng',
					component: sijiyangshengList
				},
				{
					path: 'sijiyangshengDetail',
					component: sijiyangshengDetail
				},
				{
					path: 'sijiyangshengAdd',
					component: sijiyangshengAdd
				},
				{
					path: 'yangshengchanpin',
					component: yangshengchanpinList
				},
				{
					path: 'yangshengchanpinDetail',
					component: yangshengchanpinDetail
				},
				{
					path: 'yangshengchanpinAdd',
					component: yangshengchanpinAdd
				},
				{
					path: 'sijifenlei',
					component: sijifenleiList
				},
				{
					path: 'sijifenleiDetail',
					component: sijifenleiDetail
				},
				{
					path: 'sijifenleiAdd',
					component: sijifenleiAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
				{
					path: 'aboutus',
					component: aboutusList
				},
				{
					path: 'aboutusDetail',
					component: aboutusDetail
				},
				{
					path: 'aboutusAdd',
					component: aboutusAdd
				},
				{
					path: 'systemintro',
					component: systemintroList
				},
				{
					path: 'systemintroDetail',
					component: systemintroDetail
				},
				{
					path: 'systemintroAdd',
					component: systemintroAdd
				},
				{
					path: 'discussyangshengtuijian',
					component: discussyangshengtuijianList
				},
				{
					path: 'discussyangshengtuijianDetail',
					component: discussyangshengtuijianDetail
				},
				{
					path: 'discussyangshengtuijianAdd',
					component: discussyangshengtuijianAdd
				},
				{
					path: 'discussyangshengwenzhang',
					component: discussyangshengwenzhangList
				},
				{
					path: 'discussyangshengwenzhangDetail',
					component: discussyangshengwenzhangDetail
				},
				{
					path: 'discussyangshengwenzhangAdd',
					component: discussyangshengwenzhangAdd
				},
				{
					path: 'discussyangshengzhishi',
					component: discussyangshengzhishiList
				},
				{
					path: 'discussyangshengzhishiDetail',
					component: discussyangshengzhishiDetail
				},
				{
					path: 'discussyangshengzhishiAdd',
					component: discussyangshengzhishiAdd
				},
				{
					path: 'discussyangshengfenxiang',
					component: discussyangshengfenxiangList
				},
				{
					path: 'discussyangshengfenxiangDetail',
					component: discussyangshengfenxiangDetail
				},
				{
					path: 'discussyangshengfenxiangAdd',
					component: discussyangshengfenxiangAdd
				},
				{
					path: 'discusssijiyangsheng',
					component: discusssijiyangshengList
				},
				{
					path: 'discusssijiyangshengDetail',
					component: discusssijiyangshengDetail
				},
				{
					path: 'discusssijiyangshengAdd',
					component: discusssijiyangshengAdd
				},
				{
					path: 'discussyangshengchanpin',
					component: discussyangshengchanpinList
				},
				{
					path: 'discussyangshengchanpinDetail',
					component: discussyangshengchanpinDetail
				},
				{
					path: 'discussyangshengchanpinAdd',
					component: discussyangshengchanpinAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
