import request from '@/utils/request'

// 查询存储地点查询列表
export function listWh(query) {
  return request({
    url: '/system/wh/list',
    method: 'get',
    params: query
  })
}

// 查询存储地点查询详细
export function getWh(id) {
  return request({
    url: '/system/wh/' + id,
    method: 'get'
  })
}

// 新增存储地点查询
export function addWh(data) {
  return request({
    url: '/system/wh',
    method: 'post',
    data: data
  })
}

// 修改存储地点查询
export function updateWh(data) {
  return request({
    url: '/system/wh',
    method: 'put',
    data: data
  })
}

// 删除存储地点查询
export function delWh(id) {
  return request({
    url: '/system/wh/' + id,
    method: 'delete'
  })
}
