import request from '@/utils/request'

// 查询生产领料单查询D列表
export function listSCLLDCXD(query) {
  return request({
    url: '/system/SCLLDCXD/list',
    method: 'get',
    params: query
  })
}

// 查询生产领料单查询D详细
export function getSCLLDCXD(name) {
  return request({
    url: '/system/SCLLDCXD/' + name,
    method: 'get'
  })
}


