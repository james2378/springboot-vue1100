import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import discussyangshengchanpin from '@/views/modules/discussyangshengchanpin/list'
    import yangshengtuijian from '@/views/modules/yangshengtuijian/list'
    import tizhiceshi from '@/views/modules/tizhiceshi/list'
    import yinshileixing from '@/views/modules/yinshileixing/list'
    import systemintro from '@/views/modules/systemintro/list'
    import yonghu from '@/views/modules/yonghu/list'
    import yangshengfenxiang from '@/views/modules/yangshengfenxiang/list'
    import yangshengwenzhang from '@/views/modules/yangshengwenzhang/list'
    import news from '@/views/modules/news/list'
    import aboutus from '@/views/modules/aboutus/list'
    import yangshengfenlei from '@/views/modules/yangshengfenlei/list'
    import discussyangshengzhishi from '@/views/modules/discussyangshengzhishi/list'
    import discusssijiyangsheng from '@/views/modules/discusssijiyangsheng/list'
    import yangshengchanpin from '@/views/modules/yangshengchanpin/list'
    import forum from '@/views/modules/forum/list'
    import chanpinfenlei from '@/views/modules/chanpinfenlei/list'
    import discussyangshengfenxiang from '@/views/modules/discussyangshengfenxiang/list'
    import discussyangshengtuijian from '@/views/modules/discussyangshengtuijian/list'
    import discussyangshengwenzhang from '@/views/modules/discussyangshengwenzhang/list'
    import yangshengzhishi from '@/views/modules/yangshengzhishi/list'
    import chat from '@/views/modules/chat/list'
    import sijiyangsheng from '@/views/modules/sijiyangsheng/list'
    import orders from '@/views/modules/orders/list'
    import config from '@/views/modules/config/list'
    import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
    path: '/',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center', affix: true}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/discussyangshengchanpin',
        name: '养生产品评论',
        component: discussyangshengchanpin
      }
      ,{
	path: '/yangshengtuijian',
        name: '养生推荐',
        component: yangshengtuijian
      }
      ,{
	path: '/tizhiceshi',
        name: '体质测试',
        component: tizhiceshi
      }
      ,{
	path: '/yinshileixing',
        name: '饮食类型',
        component: yinshileixing
      }
      ,{
	path: '/systemintro',
        name: '系统简介',
        component: systemintro
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/yangshengfenxiang',
        name: '养生分享',
        component: yangshengfenxiang
      }
      ,{
	path: '/yangshengwenzhang',
        name: '养生文章',
        component: yangshengwenzhang
      }
      ,{
	path: '/news',
        name: '公告信息',
        component: news
      }
      ,{
	path: '/aboutus',
        name: '关于我们',
        component: aboutus
      }
      ,{
	path: '/yangshengfenlei',
        name: '养生分类',
        component: yangshengfenlei
      }
      ,{
	path: '/discussyangshengzhishi',
        name: '养生知识评论',
        component: discussyangshengzhishi
      }
      ,{
	path: '/discusssijiyangsheng',
        name: '四季养生评论',
        component: discusssijiyangsheng
      }
      ,{
	path: '/yangshengchanpin',
        name: '养生产品',
        component: yangshengchanpin
      }
      ,{
	path: '/forum',
        name: '论坛管理',
        component: forum
      }
      ,{
	path: '/chanpinfenlei',
        name: '产品分类',
        component: chanpinfenlei
      }
      ,{
	path: '/discussyangshengfenxiang',
        name: '养生分享评论',
        component: discussyangshengfenxiang
      }
      ,{
	path: '/discussyangshengtuijian',
        name: '养生推荐评论',
        component: discussyangshengtuijian
      }
      ,{
	path: '/discussyangshengwenzhang',
        name: '养生文章评论',
        component: discussyangshengwenzhang
      }
      ,{
	path: '/yangshengzhishi',
        name: '养生知识',
        component: yangshengzhishi
      }
      ,{
	path: '/chat',
        name: '在线咨询',
        component: chat
      }
      ,{
	path: '/sijiyangsheng',
        name: '四季养生',
        component: sijiyangsheng
      }
      ,{
        path: '/orders/:status',
        name: '订单管理',
        component: orders
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/newstype',
        name: '公告信息分类',
        component: newstype
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
